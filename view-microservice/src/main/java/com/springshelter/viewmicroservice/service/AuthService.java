package com.springshelter.viewmicroservice.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public String getGreeting() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String greeting = "Welcome User!";
        String principal = auth.getPrincipal().toString();

        if (principal.contains("given_name=")) {
            String name = principal.substring(principal.indexOf("given_name=") + 11);
            name = name.substring(0, name.indexOf(","));
            greeting = "Welcome " + name + "!";
        }
        return greeting;
    }
}
