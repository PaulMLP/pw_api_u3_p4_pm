package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.IMateriaService;
import com.example.demo.service.to.MateriaTO;

@RestController
@RequestMapping("/materias") // path del controlador (plural)
public class MateriaControllerRestFul {

	@Autowired
	private IMateriaService materiaService;


	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<MateriaTO> consultarPorId(@PathVariable Integer id) {

		MateriaTO materia = this.materiaService.buscarPorIdTO(id); // Link
		return new ResponseEntity<>(materia, null, 200);

	}

	// POST
	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Materia materia) {
		this.materiaService.guardar(materia);
	}
}
