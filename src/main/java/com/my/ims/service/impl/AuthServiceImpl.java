package com.my.ims.service.impl;

import com.my.ims.model.auth.AuthVO;
import com.my.ims.model.auth.JwtResponseDTO;
import com.my.ims.model.auth.LoginDTO;
import com.my.ims.service.AuthService;
import com.my.ims.util.security.JwtTokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public AuthVO login(AuthVO authVO) {

        LoginDTO loginDTO = authVO.getLoginDTO();
        log.debug("Request to authenticate user");

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDTO.getUsernameOrEmail(),
                loginDTO.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        JwtResponseDTO jwtResponseDTO = new JwtResponseDTO();
        jwtResponseDTO.setAccessToken(token);
        authVO.setJwtResponseDTO(jwtResponseDTO);

        return authVO;
    }
}
