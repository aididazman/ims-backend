package com.my.ims.model.auth;

import java.util.Objects;

public class UserPrincipalDTO {

    private UserDTO user;

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipalDTO that = (UserPrincipalDTO) o;
        return Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserPrincipalDTO{");
        sb.append("user=").append(user);
        sb.append('}');
        return sb.toString();
    }
}
