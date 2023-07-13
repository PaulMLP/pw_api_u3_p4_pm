package com.example.demo.service;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaService {

	public Materia seleccionarPorId(Integer id);

	public void guardar(Materia materia);
}
