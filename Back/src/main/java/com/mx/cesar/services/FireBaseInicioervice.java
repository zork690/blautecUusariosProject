package com.mx.cesar.services;

import java.io.FileInputStream;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FireBaseInicioervice {

	private static final Logger LOG = LoggerFactory.getLogger(FireBaseInicioervice.class);

	@PostConstruct
	public void firebaseInit() {
		try {
			FileInputStream serviceAccount =
					  new FileInputStream("./clavePrivada.json");

					FirebaseOptions options = new FirebaseOptions.Builder()
					  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
					  .build();

					FirebaseApp.initializeApp(options);

		} catch (Exception e) {
			LOG.error("ERROR INICIANDO: " + e.toString());
		}

	}
}
