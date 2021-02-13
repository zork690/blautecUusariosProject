package com.mx.cesar.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(WebSecurity.class);

    /**
     * Use to create instance of {@link FirebaseAuthenticationTokenFilter}.
     *
     * @return instance of {@link FirebaseAuthenticationTokenFilter}
     */
    public FirebaseTokenFilter firebaseAuthenticationFilterBean() throws Exception {
        logger.error(
                "firebaseAuthenticationFilterBean():: creating instance of FirebaseAuthenticationFilter.");

        FirebaseTokenFilter authenticationTokenFilter = new FirebaseTokenFilter();

        return authenticationTokenFilter;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                
                //.sessionManagement()
                //.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
        // Custom security filter
       .addFilterBefore(firebaseAuthenticationFilterBean(),
                UsernamePasswordAuthenticationFilter.class);
    }

}
