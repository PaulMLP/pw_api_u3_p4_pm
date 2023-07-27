package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.IMateriaService;

@RestController
@RequestMapping("/materias") // path del controlador (plural)
public class MateriaControllerRestFul {

	@Autowired
	private IMateriaService materiaService;

	// GET
	@GetMapping(path = "/buscar")
	public Materia consultarPorId() {
		Integer id = 1;
		return this.materiaService.seleccionarPorId(id);
	}

	// POST
	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Materia materia) {
		this.materiaService.guardar(materia);
	}
}
