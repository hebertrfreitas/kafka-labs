package com.hebertrfreitas.kafkalabs.serviceproducer;


import javax.validation.constraints.NotNull;

public class Message {

    @NotNull(message = "Message subject is required")
    private String subject;

    @NotNull(message = "Message body is required")
    private String body;

    public Message() {
    }

    public Message(String subject, String body) {
        this.subject = subject;
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Message{" +
                "subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }



}
