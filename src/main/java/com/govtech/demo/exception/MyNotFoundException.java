package com.govtech.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

/**
 * @author Sarav on 09 Jan 2023
 * @project govtech
 * @package com.govtech.viswa.exception
 * @class MyNotFoundException
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MyNotFoundException extends RuntimeException implements Serializable {
    public MyNotFoundException(String message) {
        super(message);
    }
}
