package com.beta.replyservice.exceptions;

import com.beta.replyservice.entity.ErrorObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.security.NoSuchAlgorithmException;


@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<ErrorObject> numberFormatException(NumberFormatException ex){
        System.out.println("NumberFormatException");
         ErrorObject errorObject =  new ErrorObject();
         errorObject.setMessage("Invalid Input");
        return  new ResponseEntity<ErrorObject>(errorObject, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorObject> constraintViolationException(ConstraintViolationException ex){
        ErrorObject errorObject =  new ErrorObject();
        System.out.println("NumberFormatException1");
        errorObject.setMessage("Invalid Input");
        return  new ResponseEntity<ErrorObject>(errorObject, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NoSuchAlgorithmException.class)
    public ResponseEntity<ErrorObject> noSuchAlgorithmException(NoSuchAlgorithmException ex){
        ErrorObject errorObject =  new ErrorObject();
        errorObject.setMessage(ex.getMessage());
        return  new ResponseEntity<ErrorObject>(errorObject, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ErrorObject> invalidInputException(InvalidInputException ex){
        System.out.println("NumberFormatException2");
        ErrorObject errorObject =  new ErrorObject();
        errorObject.setMessage(ex.getMessage());
        return  new ResponseEntity<ErrorObject>(errorObject, HttpStatus.BAD_REQUEST);
    }
}
