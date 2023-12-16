package com.govtech.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Sarav on 09 Jan 2023
 * @project govtech
 * @package com.govtech.viswa.exception
 * @class ApiExceptionHandler
 */

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler  {

    @ExceptionHandler({ MyNotFoundException.class })
    protected final ResponseEntity < Object > handleNotFoundException(MyNotFoundException ex) {
        RuntimeException myex = ( ( RuntimeException ) ex );

        Map< String, Object > body = new LinkedHashMap<>();
        body.put("message", myex.getMessage());
        body.put("status", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity <>( body, HttpStatus.NOT_FOUND );
    }

    @ExceptionHandler({ ExceptionDescriptionShouldNotBeNull.class })
    protected final ResponseEntity < Object > handleNotFoundException(ExceptionDescriptionShouldNotBeNull ex) {
        RuntimeException myex = ( ( RuntimeException ) ex );

        Map< String, Object > body = new LinkedHashMap<>();
        body.put("message", myex.getMessage());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity <>( body, HttpStatus.BAD_REQUEST );
    }

    @ExceptionHandler({ ExceptionSaved.class })
    protected final ResponseEntity < Object > handleNotFoundException(ExceptionSaved ex) {
        RuntimeException myex = ( ( RuntimeException ) ex );

        Map< String, Object > body = new LinkedHashMap<>();
        body.put("message", myex.getMessage());
        body.put("status", HttpStatus.OK.value());
        return new ResponseEntity <>( body, HttpStatus.OK );
    }


}
