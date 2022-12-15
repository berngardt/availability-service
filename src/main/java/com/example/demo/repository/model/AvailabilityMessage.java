package com.example.demo.repository.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("availability")
public class AvailabilityMessage {
    private String message;
    private String lang;

    public AvailabilityMessage(String message, String lang) {
        this.message = message;
        this.lang = lang;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
