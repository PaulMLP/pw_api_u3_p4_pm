package com.example.demo.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IMateriaService;
import com.example.demo.service.to.EstudianteTO;
import com.example.demo.service.to.MateriaTO;

@RestController
@RequestMapping("/estudiantes") // path del controlador (plural)
@CrossOrigin
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;
	@Autowired
	private IMateriaService materiaService;

	// GET
	@GetMapping(path = "/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE) // pathvariable
	// @GetMapping(path = "/{cedula}", produces = "application/xml") // pathvariable
	@ResponseStatus(code = HttpStatus.OK)
	// anotacion del parametro con el @PathVariable
	public Estudiante consultarPorCedula(@PathVariable String cedula) {
		return this.estudianteService.seleccionarPorCedula(cedula);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstudianteTO>> consultarTodos() {
		List<EstudianteTO> lista = this.estudianteService.buscarTodos();
		for (EstudianteTO e : lista) {
			Link myLink = linkTo(methodOn(EstudianteControllerRestFul.class).buscarPorEstudiante(e.getCedula()))
					.withRel("materias");
			e.add(myLink);
		}
		return new ResponseEntity<>(lista, new HttpHeaders(), 200);
	}

//	@GetMapping(path = "/hateoas", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<EstudianteTO>> consultarTodosHATEOAS() {
//		List<EstudianteTO> lista = this.estudianteService.buscarTodos();
//		for (EstudianteTO e : lista) {
//			Link myLink = linkTo(methodOn(EstudianteControllerRestFul.class).buscarPorEstudiante(e.getCedula()))
//					.withRel("materias");
//			e.add(myLink);
//		}
//		return new ResponseEntity<>(lista, null, 200);
//	}
	
	/*@GetMapping
	public ResponseEntity<List<Estudiante>> consultarTodos(@RequestParam String provincia){
		//return this.estudianteService.buscarTodos(provincia);
		List<Estudiante> lista = this.estudianteService.buscarTodos(provincia);
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("detalleMensaje", "Estudiantes encontrados");
		cabeceras.add("valorAPI", "Incalculable");
		return new ResponseEntity<List<Estudiante>>(lista, cabeceras,227);
	}*/

	// POST
	@PostMapping(consumes = "application/json", produces = "application/json")
	public Estudiante insertarEstudiante(@RequestBody Estudiante estudiante) {
		return this.estudianteService.insertarEstudiante(estudiante);
	}

	// POST
//	@PostMapping(consumes = "application/xml")
//	public void guardar(@RequestBody Estudiante estudiante) {
//		this.estudianteService.guardar(estudiante);
//	}

	// PUT
	@PutMapping(path = "/{identificador}")
	public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
		estudiante.setId(identificador);
		this.estudianteService.actualizar(estudiante);
	}

	// PATCH
	@PatchMapping(path = "/{identificador}")
	public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
		estudiante.setId(identificador);

		String cedula = "1001865409";
		Estudiante estu1 = this.estudianteService.seleccionarPorCedula(cedula);
		estu1.setCedula(estudiante.getCedula());

		this.estudianteService.actualizar(estu1);
	}

	// DELETE
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
	public Estudiante borrar(@PathVariable Integer id) {
		Estudiante est = this.estudianteService.buscarPorId(id);
		this.estudianteService.eliminar(id);
		return est;
	}

	@GetMapping(path = "/{cedula}/materias", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MateriaTO>> buscarPorEstudiante(@PathVariable String cedula) {

		List<MateriaTO> lista = this.materiaService.buscarPorCedulaEstudiante(cedula);

		for (MateriaTO m : lista) {
			Link myLink = linkTo(methodOn(MateriaControllerRestFul.class).consultarPorId(m.getId())).withSelfRel();

			m.add(myLink);
		}

		return new ResponseEntity<>(lista, null, 200);

	}

}
