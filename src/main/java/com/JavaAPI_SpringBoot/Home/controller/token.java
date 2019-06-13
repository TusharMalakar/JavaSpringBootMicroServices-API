package com.JavaAPI_SpringBoot.Home.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JavaAPI_SpringBoot.Home.model.JwtUser;
import com.JavaAPI_SpringBoot.Home.security.JwtGenerator;

/**
 * Used by {@link ExceptionTranslationFilter} to commence an authentication scheme.
 *
 * @author Tushar Malakar
 */


@RestController
@RequestMapping("/token")
public class token {


    private JwtGenerator jwtGenerator;

    public token(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping
    public String generate(@RequestBody final JwtUser jwtUser) {

        return jwtGenerator.generate(jwtUser);

    }
}

