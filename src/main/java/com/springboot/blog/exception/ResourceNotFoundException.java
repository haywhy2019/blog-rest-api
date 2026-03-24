package com.springboot.blog.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends  RuntimeException{
    @Getter
    private String resourceName;

    public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue) {
        super (String.format("%s not found with %s: '%s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
    }

}
