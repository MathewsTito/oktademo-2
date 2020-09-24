package com.vakyam.oauth.okta.oktademo;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home(@AuthenticationPrincipal OidcUser user) {
        //return "Welcome, "+ user.getFullName() + "!";
        return user.getAttributes().toString();
         //return user.getAuthorities().stream().map(n->n.getAuthority().toString()).collect(Collectors.joining(","));
        //return user.getClaims().toString();
    }

    @GetMapping("/greetings")
    public String greetings(@AuthenticationPrincipal OidcUser user) {
        return "Welcome, "+ user.getFullName() + "!";
    }
}
