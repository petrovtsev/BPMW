package com.bpmw.services;

import com.bpmw.persistence.Task;
import com.bpmw.persistence.TaskGroup;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class TestValidateService extends Assert{

    @Test
    public void testValidate(){
        ValidateService validateService = new ValidateService();
        Date date = new Date();

        TaskGroup taskGroup = new TaskGroup();
        taskGroup.setId(1);
        taskGroup.setName("Support");

        Task task = new Task();
        task.setId(1);
        task.setName("Problem");
        task.setTextTask("The problem");
        task.setTaskGroup(taskGroup);
        task.setDateIn(date);
        Boolean b = false;
        Boolean validTaskGroup = validateService.validate(taskGroup);
        Boolean validTask = validateService.validate(task);

//        assertEquals(b, validTaskGroup);
//        assertEquals(b, validTask);
        assertTrue(validTask);
    }
}
