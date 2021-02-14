package com.mx.cesar.services;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

@Component
public class FirebaseTokenFilter extends OncePerRequestFilter {

	private static final Logger logger = LoggerFactory.getLogger(FirebaseTokenFilter.class);
	private final static String TOKEN_HEADER = "Authorization";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		logger.error("AUTENTICANDO PETICION...");
		HttpServletRequest httpRequest = request;
		if (httpRequest.getHeader(TOKEN_HEADER) != null) {

			String authToken = httpRequest.getHeader(TOKEN_HEADER).split("Bearer ")[1];
			logger.error("El token es: " + authToken);

			try {
				verificaId(authToken);
				filterChain.doFilter(request, response);
			} catch (FirebaseAuthException e) {
				logger.error("ERROR VALIDANDO TOKEN " + e);
			}
		}else {
			logger.error("TOKEN HEADER NULL...");
		}
	}

	private void verificaId(String idToken) throws FirebaseAuthException {
		FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
		decodedToken.getUid();
	}
}
