package com.bpmw.services;

import org.junit.Assert;
import org.junit.Test;

public class TestMessageService extends Assert{

    @Test
    public void testAddMessage(){
        MessageService messageService = new MessageService();
        messageService.addMessage("Test completed");
        assertEquals("Test completed", messageService.getMessages().get(0));
        assertTrue(messageService.getMessageStatus());
    }
}
