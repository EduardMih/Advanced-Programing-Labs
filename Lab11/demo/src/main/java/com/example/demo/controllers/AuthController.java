package com.example.demo.controllers;

import com.example.demo.Security.JwtUtils;
import com.example.demo.Security.MyUserDetailsService;
import com.example.demo.model.AuthRequest;
import com.example.demo.model.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping
    public ResponseEntity<?> createToken(@RequestBody AuthRequest authRequest) throws Exception
    {
        UserDetails userDetails;
        String jwt;
        try
        {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPass()));
        }
        catch(BadCredentialsException e)
        {
            throw new Exception("Username/password invalid");
        }

        userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        jwt = jwtUtils.generateToken(userDetails);

        return new ResponseEntity<>(new AuthResponse(jwt), HttpStatus.OK);


    }
}
