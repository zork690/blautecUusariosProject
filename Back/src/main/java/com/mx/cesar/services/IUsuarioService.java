package com.mx.cesar.services;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.mx.cesar.entities.Usuario;

public interface IUsuarioService {

	public List<Usuario> listarUsuarios();
	public Usuario guardarsuario(Usuario usuario);
	public Usuario editarUsuario(String id, Usuario usuario);
	public void borrarUsuario(String id);
}
