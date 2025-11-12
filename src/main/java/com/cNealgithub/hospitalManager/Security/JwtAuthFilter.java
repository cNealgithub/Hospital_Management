package com.cNealgithub.hospitalManager.Security;

import com.cNealgithub.hospitalManager.Entity.User;
import com.cNealgithub.hospitalManager.Repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private final UserRepository userRepository;
    private final AuthUtil authUtil;
    private final HandlerExceptionResolver handlerExceptionResolver;

        @Override
        protected void doFilterInternal (HttpServletRequest request, HttpServletResponse response, FilterChain
        filterChain) throws ServletException, IOException {
            try{
        log.info("incomming requests: {}", request.getRequestURL());
        final String requestTokenHeader = request.getHeader("Authorization");
        if (requestTokenHeader == null || !requestTokenHeader.startsWith("Bearer")) {
            filterChain.doFilter(request, response);
            return;
        }
        //always add a space after Bearer like this ("Bearer ")
        String token = requestTokenHeader.split("Bearer ")[1];
        String username = authUtil.getUsernameFromToken(token);
        //filling to security context holder with the token from jwt to allow user the use of endpoints
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            User user = userRepository.findByUsername(username).orElseThrow();
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
        //once checked and added token now move the user forward in the chain
        filterChain.doFilter(request, response);
    }catch(Exception ex){
                handlerExceptionResolver.resolveException(request, response, null, ex);
        }
    }
}
