package com.mx.cesar.services;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.mx.cesar.entities.Usuario;

public class FireBaseService {

	@Autowired
	private Firestore dbFirestore;
	
	private static final Logger LOG = LoggerFactory.getLogger(FireBaseService.class);
	private static final String COLECION = "usuarios";
	private CollectionReference docRef = dbFirestore.collection("usuarios");

	/*public Usuario listarUsuarios(String name) throws InterruptedException, ExecutionException {
		ApiFuture<DocumentSnapshot> future = docRef.get();
		DocumentSnapshot document = future.get();
		Usuario usuario = null;
		if (document.exists()) {
			usuario = document.toObject(Usuario.class);
			return usuario;
		}
		return null;
	}*/
	
	public void guardarUsuario(Usuario usuario) throws InterruptedException, ExecutionException {
		LOG.error("USUARIO A GUARDAR: "+usuario.getId());
		 ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COLECION).
				 document(usuario.getId())
				 .set(usuario);  
		 LOG.error(collectionsApiFuture.get().getUpdateTime().toString());  
		 } 

	public String actualizarUsuario(Usuario usuario) throws InterruptedException, ExecutionException {
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COLECION).document(usuario.getId()).set(usuario);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}
	
	public String borrarUsuario(String id) {
		dbFirestore.collection(COLECION).document(id).delete();
		return "Document with Usuario ID "+id+" ha sido borrado";
	}
}
