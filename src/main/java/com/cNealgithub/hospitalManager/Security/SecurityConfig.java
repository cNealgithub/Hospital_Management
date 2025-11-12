package com.cNealgithub.hospitalManager.Security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;
    @Bean
    public SecurityFilterChain webSecurityConfig(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf(csrfConfig -> csrfConfig.disable())
                .sessionManagement(sessionConfig -> sessionConfig
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll()
//                        .requestMatchers("/public/**").permitAll()
//                        .requestMatchers("/private/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user1 = User.withUsername("neal")
//                .password(passwordEncoder.encode("pass_admin"))
//                .roles("ADMIN")
//                .build();
//        UserDetails user2 = User.withUsername("user")
//                .password(passwordEncoder.encode("upass"))
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user1, user2);
//    }
}
