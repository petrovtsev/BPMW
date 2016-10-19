package com.bpmw.services;

import org.junit.Assert;
import org.junit.Test;

public class TestPasswordService extends Assert{

    @Test
    public void testPasswordHash() {
        PasswordService passwordService = new PasswordService();
        String hash = passwordService.passwordHash("user");
        assertEquals("04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb", hash);
    }
}
