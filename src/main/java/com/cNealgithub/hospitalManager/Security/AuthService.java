package com.cNealgithub.hospitalManager.Security;

import com.cNealgithub.hospitalManager.DTO.LoginRequestDTO;
import com.cNealgithub.hospitalManager.DTO.LoginResponseDTO;
import com.cNealgithub.hospitalManager.DTO.SignupResponseDTO;
import com.cNealgithub.hospitalManager.Entity.User;
import com.cNealgithub.hospitalManager.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword())
        );
        User user = (User) authentication.getPrincipal();

        String token = authUtil.generateAccessToken(user);
        return new LoginResponseDTO(token, user.getId());
    }

    public SignupResponseDTO signup(LoginRequestDTO signupRequest) {
        User user = userRepository.findByUsername(signupRequest.getUsername()).orElse(null);
        if(user != null) throw new IllegalArgumentException("user already exists");
        user = userRepository.save(User.builder()
                        .username(signupRequest.getUsername())
                        .passWord(passwordEncoder.encode(signupRequest.getPassword()))
                .build());
        return new SignupResponseDTO(user.getId(), user.getUsername());
    }
}
