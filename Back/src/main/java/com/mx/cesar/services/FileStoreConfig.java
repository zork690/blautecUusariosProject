package com.mx.cesar.services;




import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;


public class FileStoreConfig {

	
	public Firestore getDb() {
		return FirestoreClient.getFirestore();
	}
}
