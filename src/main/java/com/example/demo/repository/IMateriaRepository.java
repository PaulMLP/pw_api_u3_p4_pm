package com.example.demo.repository;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaRepository {
	public Materia seleccionarPorId(Integer id);

	public void insertar(Materia materia);

}
