package com.kdnakt;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class MyUtil {

    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    public static long timeToLive(final int hours) {
        return TimeUnit.HOURS.toSeconds(hours)
                + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }
}