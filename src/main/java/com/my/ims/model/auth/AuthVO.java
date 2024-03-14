package com.my.ims.model.auth;

import java.io.Serializable;
import java.util.Objects;

public class AuthVO implements Serializable {

    private static final long serialVersionUID = 1870007915844573799L;

    private LoginDTO loginDTO;
    private JwtResponseDTO jwtResponseDTO;

    public LoginDTO getLoginDTO() {
        return loginDTO;
    }

    public void setLoginDTO(LoginDTO loginDTO) {
        this.loginDTO = loginDTO;
    }

    public JwtResponseDTO getJwtResponseDTO() {
        return jwtResponseDTO;
    }

    public void setJwtResponseDTO(JwtResponseDTO jwtResponseDTO) {
        this.jwtResponseDTO = jwtResponseDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthVO authVO = (AuthVO) o;
        return Objects.equals(loginDTO, authVO.loginDTO) && Objects.equals(jwtResponseDTO, authVO.jwtResponseDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loginDTO, jwtResponseDTO);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("AuthVO{");
        builder.append("loginDTO=").append(loginDTO);
        builder.append(", jwtResponseDTO=").append(jwtResponseDTO);
        builder.append('}');
        return builder.toString();
    }
}
