package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.filter;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.advice.UserAuthExceptionHandler;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.service.impl.ADSUserDetailsService;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.service.util.JWTMgmtUtilityService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static org.springframework.http.HttpStatus.*;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JWTMgmtUtilityService jwtMgmtUtilityService;
    @Autowired
    private ADSUserDetailsService adsUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws BadCredentialsException,ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");
        // Here is just an example jwt token -
        // Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhbmEuYWRtaW4iLCJleHAiOjE2NTE0MzUwODEsImlhdCI6MTY1MTM5OTA4MX0.aPH-bBsaRETUip91m3y3_UTR_EwFFbIpkyOdKSTgM70KT0a7v0uAYh4NtnFqvwEgCN7kuR8MDO5VB3rktBAwpA
        String jwtToken = null;
        String username = null;
        if(authorizationHeader == null){
//            throw new BadCredentialsException("Unauthorized Attempt");
            response.setStatus(401);
            response.getWriter().print("Unauthorized Attempt");
            return;
        }

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwtToken = authorizationHeader.substring(7);
            username = jwtMgmtUtilityService.extractUsername(jwtToken);
        }
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = adsUserDetailsService.loadUserByUsername(username);
            if (jwtMgmtUtilityService.validateToken(jwtToken, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}