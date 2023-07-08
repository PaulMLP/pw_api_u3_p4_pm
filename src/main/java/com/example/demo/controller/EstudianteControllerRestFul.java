package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes") // path del controlador (plural)
public class EstudianteControllerRestFul {
	
	@Autowired
	private IEstudianteService estudianteService;

	//GET
	@GetMapping(path = "/buscar")
	public Estudiante consultarPorCedula() {
		String cedula = "1728189521";
		return this.estudianteService.seleccionarPorCedula(cedula);
	}
}
