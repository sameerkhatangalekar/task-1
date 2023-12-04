package com.beta.replyservice;

import com.beta.replyservice.exceptions.InvalidInputException;
import com.beta.replyservice.service.HashOperation;
import com.beta.replyservice.service.Operation;
import com.beta.replyservice.service.ReverseOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;


@RestController
@Validated
public class ReplyController {
	private final Map<Integer, Operation> operationMap = new HashMap<>();


	public ReplyController(){
		operationMap.put(1, new ReverseOperation());
		operationMap.put(2, new HashOperation());
	}

	@GetMapping("/reply")
	public ReplyMessage replying() {
		return new ReplyMessage("Message is empty");
	}

	@GetMapping("/reply/{message}")
	public ReplyMessage replying(@PathVariable String message) {
		return new ReplyMessage(message);
	}

	@GetMapping("/v2/reply/{rules}-{message}")
	public ReplyMessage replying(@PathVariable @NotNull @Size(max = 2,min = 2) String rules, @PathVariable String message) throws NoSuchAlgorithmException {

		int firstOperation = Character.getNumericValue(rules.charAt(0));
		int secondOperation = Character.getNumericValue(rules.charAt(1));

		if(firstOperation ==1 && secondOperation == 1)	return new ReplyMessage(message);

		if(!operationMap.containsKey(firstOperation) || !operationMap.containsKey(secondOperation))
			throw new InvalidInputException();

		Operation firstOperationImpl = operationMap.get(firstOperation);

		String firstResult = firstOperationImpl.perform(message);
		System.out.println(firstResult);
		Operation secondOperationImpl = operationMap.get(secondOperation);
		String secondResult = secondOperationImpl.perform(firstResult);


		return new ReplyMessage(secondResult);
	}
}