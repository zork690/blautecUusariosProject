package com.mx.cesar.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InicioController {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String inicio(Map<String, Object> datosPaVista) {
		datosPaVista.put("titulo", "API REST CRUD USUARIOS");		
		return "inicio";
	}
	
	
}
