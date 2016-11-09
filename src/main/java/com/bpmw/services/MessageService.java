package com.bpmw.services;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to display summary information messages to the user.
 * @author ppetr
 * @version 1.0
 */
@RequestScoped
public class MessageService {

    /**
     * @param messageStatus - the parameter is used for information
     *                      about the presence of messages to the user.
     */
    private Boolean messageStatus = false;

    /**
     * @param messages - it contains a list of messages.
     */
    private List<String> messages = new ArrayList<String>();

    /**
     *The method receives the message and adds it to the list.
     * @param message - new message.
     */
    public void addMessage(String message){
        messageStatus = true;
        messages.add(message);
    }

    /**
     * Getters and setters
     */
    public Boolean getMessageStatus() {
        return messageStatus;
    }

    public List<String> getMessages() {
        return messages;
    }
}
