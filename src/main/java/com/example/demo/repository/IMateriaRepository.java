package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaRepository {
	public List<Materia> buscarPorCedulaEstudiante(String cedula);
	

	public Materia seleccionarPorId(Integer id);

	public void insertar(Materia materia);

}
