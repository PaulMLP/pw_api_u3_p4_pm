package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Horario;
import com.example.demo.service.IHorarioService;

@RestController
@RequestMapping("/horarios") // path del controlador (plural)
public class HorarioControllerRestFul {

	@Autowired
	private IHorarioService horarioService;

	// GET
	@GetMapping(path = "/{materia}") // pathvariable
	public ResponseEntity<Horario> consultarPorMateria(@PathVariable String materia) { // anotacion del parametro con el @PathVariable
		return ResponseEntity.status(HttpStatus.OK).body(this.horarioService.seleccionarPorMateria(materia));
		
	}

	@GetMapping
	public List<Horario> consultarTodos(@RequestParam String dia) {
		return this.horarioService.buscarTodos(dia);
	}

	// POST
	@PostMapping
	public void guardar(@RequestBody Horario horario) {
		this.horarioService.insertar(horario);
	}

	// PUT
	@PutMapping(path = "/{identificador}")
	public void actualizar(@RequestBody Horario horario, @PathVariable Integer identificador) {
		horario.setId(identificador);
		this.horarioService.actualizar(horario);
	}

	// PATCH
	@PatchMapping(path = "/{identificador}")
	public void actualizarParcial(@RequestBody Horario horario, @PathVariable Integer identificador) {
		horario.setId(identificador);

		String materia = "matematica";
		Horario hori1 = this.horarioService.seleccionarPorMateria(materia);
		hori1.setMateria(horario.getMateria());

		this.horarioService.actualizar(hori1);
	}

	// DELETE
	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
		this.horarioService.borrar(id);
		
	}

}
