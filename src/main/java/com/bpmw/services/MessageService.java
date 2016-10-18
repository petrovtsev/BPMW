package com.bpmw.services;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
@Named
public class MessageService {

    private Boolean messageStatus = false;

    private List<String> messages = new ArrayList<String>();

    public void addMessage(String message){
        messageStatus = true;
        messages.add(message);
    }

    public Boolean getMessageStatus() {
        return messageStatus;
    }

    public List<String> getMessages() {
        return messages;
    }
}
