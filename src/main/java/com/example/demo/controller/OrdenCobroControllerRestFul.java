package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.OrdenCobro;
import com.example.demo.service.IOrdenCobroService;

@RestController
@RequestMapping("/ordencobros")
public class OrdenCobroControllerRestFul {

	@Autowired
	private IOrdenCobroService cobroService;

	// GET
	@GetMapping(path = "/{estado}", produces = MediaType.APPLICATION_JSON_VALUE) // pathvariable
	@ResponseStatus(code = HttpStatus.OK)
	// anotacion del parametro con el @PathVariable
	public OrdenCobro consultarPorEstado(@PathVariable String estado) {
		return this.cobroService.buscarPorEstado(estado);
	}

	@GetMapping
	public ResponseEntity<List<OrdenCobro>> consultarTodos(@RequestParam String estado) {
		List<OrdenCobro> lista = this.cobroService.buscarTodos(estado);

		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add("detalleMensaje", "correcto");
		return new ResponseEntity<List<OrdenCobro>>(lista, cabecera, 227);
	}

	// POST
	@PostMapping(consumes = "application/json", produces = "application/json")
	public OrdenCobro insertarOrdenCobro(@RequestBody OrdenCobro ordenCobro) {
		return this.cobroService.insertarOrdenCobro(ordenCobro);
	}

	// PUT
	@PutMapping(path = "/{identificador}")
	public void actualizar(@RequestBody OrdenCobro ordenCobro, @PathVariable Integer identificador) {
		ordenCobro.setId(identificador);
		this.cobroService.actualizar(ordenCobro);
	}

	// PATCH
	@PatchMapping(path = "/{identificador}")
	public void actualizarParcial(@RequestBody OrdenCobro ordenCobro, @PathVariable Integer identificador) {
		ordenCobro.setId(identificador);

		String estado = "CANCELADO";
		OrdenCobro ordC = this.cobroService.buscarPorEstado(estado);
		ordC.setEstado(ordenCobro.getEstado());

		this.cobroService.actualizar(ordC);
	}

	// DELETE
	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
		this.cobroService.borrar(id);
	}

}
