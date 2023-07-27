package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IOrdenCobroRepository;
import com.example.demo.repository.modelo.OrdenCobro;

@Service
public class OrdenCobroImplService implements IOrdenCobroService {

	@Autowired
	private IOrdenCobroRepository ordenCobroRepository;

	@Override
	public OrdenCobro buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.ordenCobroRepository.buscarPorId(id);
	}

	@Override
	public void insertar(OrdenCobro ordenCobro) {
		// TODO Auto-generated method stub
		this.ordenCobroRepository.insertar(ordenCobro);
	}

	@Override
	public OrdenCobro buscarPorEstado(String estado) {
		// TODO Auto-generated method stub
		return this.ordenCobroRepository.buscarPorEstado(estado);
	}

	@Override
	public void actualizar(OrdenCobro ordenCobro) {
		// TODO Auto-generated method stub
		this.ordenCobroRepository.actualizar(ordenCobro);
	}

	@Override
	public void actualizarParcial(String estadoActual, String estadoNuevo) {
		// TODO Auto-generated method stub
		this.actualizarParcial(estadoActual, estadoNuevo);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.ordenCobroRepository.borrar(id);
	}

	@Override
	public List<OrdenCobro> buscarTodos(String estado) {
		// TODO Auto-generated method stub
		return this.ordenCobroRepository.buscarTodos(estado);
	}

	@Override
	public OrdenCobro insertarOrdenCobro(OrdenCobro ordenCobro) {
		// TODO Auto-generated method stub
		return this.ordenCobroRepository.insertarOrdenCobro(ordenCobro);
	}

}
