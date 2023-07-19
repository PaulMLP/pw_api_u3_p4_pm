package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Horario;

public interface IHorarioService {

	public Horario buscarPorId(Integer id);

	public Horario seleccionarPorMateria(String materia);

	public void insertar(Horario horario);

	public void actualizar(Horario horario);

	public void actualizarParcial(String materiaActual, String materiaNueva);

	public void borrar(Integer id);

	public List<Horario> buscarTodos(String dia);
}