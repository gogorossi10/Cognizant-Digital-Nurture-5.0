package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestHeader("Authorization") String authHeader) {

        LOGGER.info("Start");

        String encodedCredentials = authHeader.substring("Basic ".length());

        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);

        String credentials = new String(decodedBytes, StandardCharsets.UTF_8);

        String[] values = credentials.split(":");

        String username = values[0];
        String password = values[1];

        LOGGER.info("Username : {}", username);
        LOGGER.info("Password : {}", password);

        String token = JwtUtil.generateToken(username);

        Map<String, String> map = new HashMap<>();

        map.put("token", token);

        LOGGER.info("End");

        return map;
    }
}