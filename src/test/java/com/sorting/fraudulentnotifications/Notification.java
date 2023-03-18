package com.sorting.fraudulentnotifications;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Notification {

    @Test
    public void noSendNotification() {
        int result = Result.activityNotifications(Arrays.asList(1, 2, 3, 4, 4), 4);
        Assert.assertEquals(0, result);
    }
    @Test
    public void sendOneNotification() {
        int result = Result.activityNotifications(Arrays.asList(10, 20, 30, 40, 50), 3);
        Assert.assertEquals(1, result);
    }

    @Test
    public void sendTwoNotification() {
        int result = Result.activityNotifications(Arrays.asList(2, 3, 4, 2, 3, 6, 8, 4, 5), 5);
        Assert.assertEquals(2, result);
    }
}
