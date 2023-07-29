package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.to.MateriaTO;

public interface IMateriaService {
	public List<MateriaTO> buscarPorCedulaEstudiante(String cedula);

	public MateriaTO seleccionarPorId(Integer id);

	public void guardar(Materia materia);

	public MateriaTO buscarPorIdTO(Integer id);
	public Materia buscarPorId(Integer id);
}
