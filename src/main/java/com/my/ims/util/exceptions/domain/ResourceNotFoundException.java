package com.my.ims.util.exceptions.domain;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 2470373595186049453L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
