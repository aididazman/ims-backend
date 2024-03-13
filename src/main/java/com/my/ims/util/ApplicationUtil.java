package com.my.ims.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ApplicationUtil {

    private ApplicationUtil() {
        throw new IllegalStateException("Util class");
    }

    public static Instant getLocalTime() {
        ZonedDateTime localTime = ZonedDateTime.now(ZoneId.of("Asia/Kuala_Lumpur"));
        return localTime.toInstant();
    }
}
