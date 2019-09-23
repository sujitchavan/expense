package com.springboot.expencemanager.exceptions;

import java.util.Date;
import java.util.List;

public class ErrorMessage {
    private Date timestamp;
    private List<String> message;

    public ErrorMessage() {
    }

    public ErrorMessage(Date timestamp, List<String> message) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public Date getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    public List<String> getMessage() {
        return message;
    }
    public void setMessage(List<String> message) {
        this.message = message;
    }
}
