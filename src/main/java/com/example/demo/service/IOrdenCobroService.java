package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.OrdenCobro;

public interface IOrdenCobroService {
	public OrdenCobro buscarPorId(Integer id);

	public void insertar(OrdenCobro ordenCobro);

	public OrdenCobro buscarPorEstado(String estado);

	public void actualizar(OrdenCobro ordenCobro);

	public void actualizarParcial(String estadoActual, String estadoNuevo);

	public void borrar(Integer id);

	public List<OrdenCobro> buscarTodos(String estado);

	public OrdenCobro insertarOrdenCobro(OrdenCobro ordenCobro);
}
