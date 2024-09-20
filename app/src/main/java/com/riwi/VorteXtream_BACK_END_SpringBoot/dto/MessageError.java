package com.riwi.VorteXtream_BACK_END_SpringBoot.dto;

public class MessageError {
    private String message;

    public MessageError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
