package com.mx.cesar.services;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.mx.cesar.entities.Usuario;

@Service
public class FireBaseService {

	private static final Logger LOG = LoggerFactory.getLogger(FireBaseService.class);

	public void guardarUsuario(Usuario usuario) {
		try {
			LOG.error("GUARDANDO EN FIREBASE " + usuario.getId());
			Firestore dbFirestore = FirestoreClient.getFirestore();
			ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("usuarios").document(usuario.getId())
					.set((usuario));
			LOG.error(collectionsApiFuture.get().getUpdateTime().toString());

		} catch (InterruptedException e) {
			LOG.error("ERROR GUARDANDO1 "+e.toString());
		} catch (ExecutionException e) {
			LOG.error("ERROR GUARDANDO2 "+e.toString());
		}
	}

	public void actualizarUsuario(Usuario usuario){
		try {
		LOG.error("ACTUALIZANDO EN FIREBASE "+usuario.getId());
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("usuarios").document(usuario.getId())
				.set(usuario);
		LOG.error(collectionsApiFuture.get().getUpdateTime().toString());
		} catch (InterruptedException e) {
			LOG.error("ERROR ACTUALIZANDO2 "+e.toString());
		} catch (ExecutionException e) {
			LOG.error("ERROR ACTUALIZANDO2 "+e.toString());
		}
	}

	public void borrarUsuario(String id) {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		dbFirestore.collection("usuarios").document(id).delete();
		LOG.error("BORRADO DE FIREBASE USUARIO "+id);
	}
}
