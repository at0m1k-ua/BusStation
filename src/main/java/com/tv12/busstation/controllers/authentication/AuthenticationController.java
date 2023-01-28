package com.tv12.busstation.controllers.authentication;

import com.tv12.busstation.models.AuthenticationModel;
import com.tv12.busstation.models.MainModel;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.spi.LoginModule;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    @PostMapping("/auth")
    public ModelAndView redirect(@RequestParam String email,
                                 @RequestParam String password){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        if (userDetails != null) {
            return new MainModel();
        }
        return new AuthenticationModel();
    }
}
