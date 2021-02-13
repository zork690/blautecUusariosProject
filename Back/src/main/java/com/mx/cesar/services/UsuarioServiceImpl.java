package com.mx.cesar.services;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.cesar.daos.IUsuarioDao;
import com.mx.cesar.entities.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	private static final Logger LOG = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	
	
	@Override
	public List<Usuario> listarUsuarios(){
		return usuarioDao.findAll();
	}
	
	@Override
	public Usuario guardarsuario(Usuario usuario) throws InterruptedException, ExecutionException {
		Usuario usuarioGuardado = usuarioDao.save(usuario);
		LOG.error("USUARIO CREADO: "+usuario.getId());
		new FireBaseService().guardarUsuario(usuarioGuardado);
		//firebaseService.guardarUsuario(usuarioGuardado);
		return usuario;
	}
	
	@Override
	public Usuario editarUsuario(String id, Usuario usuario) {
		Usuario usuarioActual = usuarioDao.findById(id).orElse(null);
		usuarioActual.setNombre(usuario.getNombre());
		usuarioActual.setApellido(usuario.getApellido());
		usuarioActual.setFechaNacimiento(usuario.getFechaNacimiento());
		usuarioDao.save(usuarioActual);
		return usuarioActual;
	}
	
	@Override
	public void borrarUsuario(String id) {
		usuarioDao.deleteById(id);
	}

}
