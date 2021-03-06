package com.mx.cesar.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mx.cesar.entities.Usuario;
import com.mx.cesar.services.IUsuarioService;

@RestController
public class InicioRest {
	
	private static final Logger log = LoggerFactory.getLogger(InicioRest.class);
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@PostMapping("/listarUsuarios")
	@CrossOrigin()
	public ResponseEntity<List<Usuario>> listar() {
		return new ResponseEntity<List<Usuario>>(usuarioService.listarUsuarios(), HttpStatus.OK);
	}
	
	
	@PostMapping("/guardarUsuario")
	@CrossOrigin()
	public ResponseEntity<Usuario> guardar(@RequestBody Usuario usuario) {
		return new ResponseEntity<Usuario>(usuarioService.guardarsuario(
				new Usuario(usuario.getNombre(), usuario.getApellido(), usuario.getFechaNacimiento())), 
				HttpStatus.CREATED);
		
		
	}
	
	@PostMapping("/editarUsuario/{id}")
	@CrossOrigin()
	public ResponseEntity<Usuario> editar(@PathVariable("id") String id, @RequestBody Usuario usuario) {
		return new ResponseEntity<Usuario>(usuarioService.editarUsuario(id, usuario), HttpStatus.OK);
	}
	
	@PostMapping("/borrarUsuario/{id}")
	@CrossOrigin()
	public ResponseEntity<HttpStatus> borrar(@PathVariable("id") String id) {
		usuarioService.borrarUsuario(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}

}
