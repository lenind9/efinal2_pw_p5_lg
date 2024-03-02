package com.uce.edu.demo.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uce.edu.demo.service.IEstudianteService;
import com.uce.edu.demo.service.to.EstudianteTO;

@RestController
@RequestMapping(path = "/estudiantes")
@CrossOrigin
public class EstudianteControllerRestFul {
	
	@Autowired
	private IEstudianteService estudianteService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void guardar(@RequestBody EstudianteTO estudiante) {
		this.estudianteService.guardar(estudiante);
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EstudianteTO> buscar(@PathVariable Integer id) {
		EstudianteTO estu = this.estudianteService.buscar(id);
		Link link = linkTo(methodOn(EstudianteControllerRestFul.class).buscar(estu.getId()))
				.withSelfRel();
		estu.add(link);
		return ResponseEntity.status(HttpStatus.OK).body(estu);
	}
}
