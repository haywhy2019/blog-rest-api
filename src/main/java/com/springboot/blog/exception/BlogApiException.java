package com.springboot.blog.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class BlogApiException  extends  RuntimeException {
    @Getter
    private HttpStatus status;
    @Getter
    private String message;

    public BlogApiException( HttpStatus status, String message) {
        this.message = message;
        this.status = status;
    }

    public BlogApiException( HttpStatus status, String message, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

}
