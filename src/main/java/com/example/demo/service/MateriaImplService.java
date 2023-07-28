package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.to.MateriaTO;

@Service
public class MateriaImplService implements IMateriaService {

	@Autowired
	private IMateriaRepository materiaRepository;

	@Override
	public MateriaTO seleccionarPorId(Integer id) {
		return this.convertirAMateria(this.materiaRepository.seleccionarPorId(id));
	}

	@Override
	public void guardar(Materia materia) {
		// TODO Auto-generated method stub
		this.materiaRepository.insertar(materia);
	}

	@Override
	public List<MateriaTO> buscarPorCedulaEstudiante(String cedula) {
		List<Materia> lista = this.materiaRepository.buscarPorCedulaEstudiante(cedula);
		List<MateriaTO> listaTO = lista.stream().map(materia -> this.convertirAMateria(materia))
				.collect(Collectors.toList());

		return listaTO;
	}

	private MateriaTO convertirAMateria(Materia mate) {
		MateriaTO materia = new MateriaTO();
		materia.setId(mate.getId());
		materia.setNombre(mate.getNombre());
		materia.setCreditos(mate.getCreditos());
		return materia;
	}

	@Override
	public Materia buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.materiaRepository.seleccionarPorId(id);
	}

}
