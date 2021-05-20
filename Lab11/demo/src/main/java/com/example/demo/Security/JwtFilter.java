package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException
    {
        String username=null, jwt=null;
        String authHeader = httpServletRequest.getHeader("Authorization");
        UserDetails userDetails;
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken;

        if((authHeader != null) && (authHeader.startsWith("Bearer")))
        {
            jwt = authHeader.substring(7);
            username = jwtUtils.extractUsername(jwt);
        }

        if((username != null) && (SecurityContextHolder.getContext().getAuthentication() == null))
        {
            userDetails = myUserDetailsService.loadUserByUsername(username);
            if(jwtUtils.validateToken(jwt, userDetails))
            {
                usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }
}
