package com.mx.cesar.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FireBaseInicioervice {

	private static final Logger LOG = LoggerFactory.getLogger(FireBaseInicioervice.class);

	@PostConstruct
	public void firebaseInit() {
		try {
			File file = ResourceUtils.getFile("classpath:clavePrivada.json");
			FileInputStream servicioAcount = new FileInputStream(file);
			FirebaseOptions firebaseOpciones = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(servicioAcount)).build();
			FirebaseApp.initializeApp(firebaseOpciones);

		} catch (Exception e) {
			LOG.error("ERROR INICIANDO: " + e.toString());
		}

	}
}
