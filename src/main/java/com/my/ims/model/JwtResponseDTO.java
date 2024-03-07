package com.my.ims.model;

import java.util.Objects;

public class JwtResponseDTO {

    private String accessToken;
    private String tokenType = "Bearer";

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JwtResponseDTO that = (JwtResponseDTO) o;
        return Objects.equals(accessToken, that.accessToken) && Objects.equals(tokenType, that.tokenType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken, tokenType);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("JwtResponseDTO{");
        builder.append("accessToken='").append(accessToken).append('\'');
        builder.append(", tokenType='").append(tokenType).append('\'');
        builder.append('}');
        return builder.toString();
    }
}
