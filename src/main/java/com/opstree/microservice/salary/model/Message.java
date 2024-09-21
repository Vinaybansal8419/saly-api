package com.opstree.microservice.salary.model;

/**
 * This package contains model classes for the salary microservice.
 */

public class Message {
    /**
     * The message content.
     */
    private String message;

    /**
     * Constructs a Message with the specified content.
     *
     * @param paramMessage the content of the message
     */
    public Message(final String paramMessage) {
        this.message = paramMessage;
    }
}

