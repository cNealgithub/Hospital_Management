package com.cNealgithub.hospitalManager.Controller;

import com.cNealgithub.hospitalManager.DTO.LoginRequestDTO;
import com.cNealgithub.hospitalManager.DTO.LoginResponseDTO;
import com.cNealgithub.hospitalManager.DTO.SignupResponseDTO;
import com.cNealgithub.hospitalManager.Security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity.ok(authService.login(loginRequestDTO));
    }
    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDTO> signup(@RequestBody LoginRequestDTO signupRequest){
        return ResponseEntity.ok(authService.signup(signupRequest));
    }
}
