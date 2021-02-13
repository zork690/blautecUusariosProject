package com.mx.cesar.daos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mx.cesar.entities.Usuario;

@Repository
public interface IUsuarioDao extends MongoRepository<Usuario, String> {

}
