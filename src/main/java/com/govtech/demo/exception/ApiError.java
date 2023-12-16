package com.govtech.demo.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Sarav on 02 Nov 2023
 * @project govtech
 * @package com.govtech.viswa.exception
 * @class ApiError
 */

@Data
public class ApiError {

    private HttpStatus status;
    private String message;
    private String error;
    private Timestamp timestamp;

    public ApiError(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        this.error = error;
        this.timestamp = new Timestamp(new Date().getTime());
    }

}
