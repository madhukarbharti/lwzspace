package org.lwz.space.service;

import org.junit.Assert;
import org.easymock.EasyMock;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    @Test
    public void testGetUser() throws Exception {
        UserService userService = EasyMock.createMock(UserService.class);
        userService.getUser();
        EasyMock.expectLastCall().andReturn(false);
        EasyMock.replay(userService);

        Assert.assertEquals(false, userService.getUser());


    }
}