package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IHorarioRepository;
import com.example.demo.repository.modelo.Horario;

@Service
public class HorarioImplService implements IHorarioService {

	@Autowired
	private IHorarioRepository horarioRepository;

	@Override
	public Horario buscarPorId(Integer id) {
		return this.horarioRepository.buscarPorId(id);
	}

	@Override
	public Horario seleccionarPorMateria(String materia) {
		return this.horarioRepository.seleccionarPorMateria(materia);
	}

	@Override
	public void insertar(Horario horario) {
		this.horarioRepository.insertar(horario);
	}

	@Override
	public void actualizar(Horario horario) {
		this.horarioRepository.actualizar(horario);
	}

	@Override
	public void actualizarParcial(String materiaActual, String materiaNueva) {
		this.horarioRepository.actualizarParcial(materiaActual, materiaNueva);
	}

	@Override
	public void borrar(Integer id) {
		this.horarioRepository.borrar(id);
	}

	@Override
	public List<Horario> buscarTodos(String dia) {
		return this.horarioRepository.buscarTodos(dia);
	}

	
}
