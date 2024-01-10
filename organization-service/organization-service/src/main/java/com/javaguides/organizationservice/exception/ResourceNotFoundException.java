package com.javaguides.organizationservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ResourceNotFoundException extends RuntimeException{

    public String resourceName;
    public String filedName;
    public String fieldValue;

    public String fieldValue2;

    public ResourceNotFoundException(String resourceName, String filedName, String fieldValue) {
        super(String.format("%s not found with %s : %s", resourceName, filedName, fieldValue));
        this.resourceName = resourceName;
        this.filedName = filedName;
        this.fieldValue = fieldValue;
    }
}
