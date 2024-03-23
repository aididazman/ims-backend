package com.my.ims.auth;

import com.my.ims.auth.AuthVO;
import com.my.ims.auth.JwtResponseDTO;
import com.my.ims.auth.LoginDTO;
import com.my.ims.auth.AuthService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation( summary = "login", tags = { "auth-controller" })
    @PostMapping("/login")
    public ResponseEntity<JwtResponseDTO> login(@RequestBody LoginDTO loginDTO) {

        log.info("REST login request: {}", loginDTO);

        AuthVO authVO = new AuthVO();
        authVO.setLoginDTO(loginDTO);
        authVO = authService.login(authVO);

        return new ResponseEntity<>(authVO.getJwtResponseDTO(), HttpStatus.OK);
    }

}
