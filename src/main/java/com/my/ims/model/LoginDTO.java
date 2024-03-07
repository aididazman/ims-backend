package com.my.ims.model;

import java.util.Objects;

public class LoginDTO {

    private String usernameOrEmail;
    private String password;

    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginDTO authDTO = (LoginDTO) o;
        return Objects.equals(usernameOrEmail, authDTO.usernameOrEmail)
                && Objects.equals(password, authDTO.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usernameOrEmail, password);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("AuthDTO{");
        builder.append("usernameOrEmail='").append(usernameOrEmail).append('\'');
        builder.append(", password='").append(password).append('\'');
        builder.append('}');
        return builder.toString();
    }
}
