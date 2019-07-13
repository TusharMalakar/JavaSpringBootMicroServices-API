package com.JavaAPI_SpringBoot.Home.config;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import com.JavaAPI_SpringBoot.Home.security.JwtSuccessHandler;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.http.SessionCreationPolicy;
import com.JavaAPI_SpringBoot.Home.security.JwtAuthenticationProvider;

import com.JavaAPI_SpringBoot.Home.security.JwtAuthenticationEntryPoint;
import org.springframework.security.authentication.AuthenticationManager;
import com.JavaAPI_SpringBoot.Home.security.JwtAuthenticationTokenFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * Used by {@link ExceptionTranslationFilter} to commence an authentication scheme.
 * @author Tushar Malakar
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
    private JwtAuthenticationProvider authenticationProvider;
    
	@Autowired
    private JwtAuthenticationEntryPoint entryPoint;
	
	@Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(Collections.singletonList(authenticationProvider));
    }
	
	//creating  a Jwt customized filter
	@Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilter() {
        JwtAuthenticationTokenFilter filter = new JwtAuthenticationTokenFilter();
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationSuccessHandler(new JwtSuccessHandler());
        return filter;
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()            //disabled all cross http requests
                .authorizeRequests().antMatchers("**/api/**").authenticated()   //check authentication all url has substring "api"
                .and()
                .exceptionHandling().authenticationEntryPoint(entryPoint)      // exception for url doesn't have substring "api"
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); //stateless management

        http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        http.headers().cacheControl();     //cache controller

    }
	
	
	
	
}
