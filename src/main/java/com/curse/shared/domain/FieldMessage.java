package com.curse.shared.domain;

import java.io.Serializable;

public class FieldMessage implements Serializable {
    private static final long serialVersionUID = 1L;


    private String fieldName;
    private String message;

    public FieldMessage() {
    }

    public FieldMessage(String fieldMessage, String message) {
        this.fieldName = fieldMessage;
        this.message = message;
    }

    public String getFieldMessage() {
        return fieldName;
    }

    public void setFieldMessage(String fieldMessage) {
        this.fieldName = fieldMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
}