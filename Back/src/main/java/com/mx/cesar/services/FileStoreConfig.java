package com.mx.cesar.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

@Configuration
public class FileStoreConfig {

	@Bean
	public Firestore getDb() {
		return FirestoreClient.getFirestore();
	}
}
