package com.govtech.demo.pojo;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiResp<T> {

    private HttpStatus status;
    private String message;
    private Integer records;
    private Object result;



    public ApiResp(HttpStatus status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
        this.records = 1;
    }

    public ApiResp(HttpStatus status, String message, Object result, Integer records) {
        this.status = status;
        this.message = message;
        this.records = records;
        this.result = result;
    }

    @Override
    public String toString() {
        return "ApiResp{" + '\n' +
                "status=" + status + '\n' +
                ", message='" + message + '\'' + '\n' +
                ", records=" + records + '\n' +
                ", result=" + result + '\n' +
                '}';
    }
}
