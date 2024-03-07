package com.my.ims.controller;

import com.my.ims.model.AuthVO;
import com.my.ims.model.JwtResponseDTO;
import com.my.ims.model.LoginDTO;
import com.my.ims.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDTO> login(@RequestBody LoginDTO loginDTO){

        AuthVO authVO = new AuthVO();
        authVO.setLoginDTO(loginDTO);

        try {
            authVO = authService.login(authVO);
        } catch (Exception e) {
            System.out.println(e);
        }

        return new ResponseEntity<>(authVO.getJwtResponseDTO(), HttpStatus.OK);
    }

}
