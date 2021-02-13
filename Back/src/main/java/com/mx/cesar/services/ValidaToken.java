package com.mx.cesar.services;

import org.springframework.stereotype.Service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

@Service
public class ValidaToken {
	
	public void verifyToken(String idToken) throws FirebaseAuthException {
        FirebaseToken decodedToken = 
        FirebaseAuth.getInstance().verifyIdToken(idToken);
        String uid = decodedToken.getUid();
    }

}
