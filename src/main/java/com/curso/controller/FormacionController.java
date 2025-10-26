package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Formacion;
import com.curso.service.FormacionService;

@CrossOrigin("*")
@RestController
@RequestMapping("/formacion")
public class FormacionController {

	@Autowired
	private FormacionService formacionService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Formacion> listadoFormacion() {
		return formacionService.getAllCursos();
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void crearCurso(@RequestBody Formacion formacion) {
		formacionService.addCurso(formacion);
	}

}
