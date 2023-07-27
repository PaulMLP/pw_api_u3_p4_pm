package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;

public interface IEstudianteService {
	public Estudiante buscarPorId(Integer id);

	public Estudiante seleccionarPorCedula(String cedula);

	public void guardar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void eliminar(Integer id);

	public List<Estudiante> buscarTodos(String provincia);
	public List<EstudianteTO> buscarTodos();
	
	public Estudiante insertarEstudiante(Estudiante estudiante);
}
