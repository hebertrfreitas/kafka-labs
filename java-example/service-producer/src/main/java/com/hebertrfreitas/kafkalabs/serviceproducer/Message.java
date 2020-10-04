package com.hebertrfreitas.kafkalabs.serviceproducer;

public class Message {

    private String subject, body;

    public Message(String subject, String body) {
        this.subject = subject;
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
