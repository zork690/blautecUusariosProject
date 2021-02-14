package com.mx.cesar.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(WebSecurity.class);
	
    public FirebaseTokenFilter firebaseAuthenticationFilterBean() throws Exception {
        logger.error( "CONFIGURANDO ADAPTADOR DE SEGURIDAD...");

        FirebaseTokenFilter authenticationTokenFilter = new FirebaseTokenFilter();

        return authenticationTokenFilter;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.cors().and().csrf().disable();
    }

}
