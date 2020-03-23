package com.kdnakt;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.concurrent.TimeUnit;

public class MyUtil {

    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    public static boolean isEqualOrBefore(final ZonedDateTime a, final ZonedDateTime b) {
        return a.isEqual(b) || a.isBefore(b);
    }

    public static long timeToLive(final int hours) {
        return TimeUnit.HOURS.toSeconds(hours)
                + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }
}