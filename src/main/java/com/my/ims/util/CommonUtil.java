package com.my.ims.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class CommonUtil {

    private CommonUtil() {
        throw new IllegalStateException("Util class");
    }

    public static LocalDateTime getLocalTime() {
        ZonedDateTime localTime = ZonedDateTime.now(ZoneId.systemDefault());
        return localTime.toLocalDateTime();
    }

    public static String getCurrentUser() {

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        if (authentication.getPrincipal() instanceof User) {
            User springSecurityUser = (User) authentication.getPrincipal();
            return springSecurityUser.getUsername();
        }

        return null;
    }

}
