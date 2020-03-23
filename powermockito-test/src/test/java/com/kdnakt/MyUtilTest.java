package com.kdnakt;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({
    System.class,
    MyUtil.class,
})
public class MyUtilTest {

    @Test
    public void testTimeToLive() {
        PowerMockito.mockStatic(System.class);
        when(System.currentTimeMillis()).thenReturn(5000L);

        long actual = MyUtil.timeToLive(1);
        assertEquals(3605, actual);
    }

}