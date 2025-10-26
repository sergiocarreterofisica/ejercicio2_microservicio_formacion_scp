package com.curso.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.curso.model.Curso;
import com.curso.model.Formacion;
import com.curso.service.FormacionService;

@Service
public class FormacionServiceImpl implements FormacionService {

	@Autowired
	private RestClient cliente;

	// URL del servicio de cursos
	private String urlServiceLibros = "http://localhost:8080/cursos";

	@Override
	public List<Formacion> getAllCursos() {

		// Obtenemos el listado de cursos existentes.
		Curso[] arrayCursos = cliente.get().uri(urlServiceLibros).retrieve().body(Curso[].class);

		// Transformamos ese listado de cursos en un listado de formación
		List<Formacion> listaFormacion = Arrays.asList(arrayCursos).stream()
				.map(curso -> new Formacion(curso.getNombre(), curso.getDuracion() >= 50.0 ? 10 : 5, curso.getPrecio()))
				.toList();
		return listaFormacion;
	}

	@Override
	public void addCurso(Formacion formacion) {

		// Creamos un curso
		Curso cursoNuevo = new Curso(this.getCodigoCurso(formacion.getNombreCurso(), formacion.getNumAsignaturas()),
				formacion.getNombreCurso(), formacion.getNumAsignaturas() * 10.0, formacion.getPrecio());

		// Comprobamos si existe previamente un curso con ese nombre.
		Curso curso = cliente.get().uri(urlServiceLibros + "/nombre/" + cursoNuevo.getNombre()).retrieve()
				.body(Curso.class);

		// Si no existe, lo creamos.
		if (curso == null) {
			cliente.post().uri(urlServiceLibros).accept(MediaType.APPLICATION_JSON).body(cursoNuevo).retrieve()
					.toBodilessEntity();
		}

	}

	// Método que obtiene el código del curso a partir de su nombre y su número de
	// asignaturas
	private String getCodigoCurso(String nombreCurso, Integer numAsignaturas) {
		return nombreCurso.substring(0, 3).concat(String.valueOf(numAsignaturas * 10));
	}

}
