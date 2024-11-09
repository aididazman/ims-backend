package com.my.ims.auth;

import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Data
public class LoginDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -6903083036467582631L;

    private String username;
    private String email;
    @ToString.Exclude
    private String password;
}
