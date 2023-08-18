package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.modelo.OrdenCobro;

@Repository
@Transactional
public class OrdenCobroImplRepository implements IOrdenCobroRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public OrdenCobro buscarPorId(Integer id) {
		return this.entityManager.find(OrdenCobro.class, id);
	}

	@Override
	public void insertar(OrdenCobro ordenCobro) {
		this.entityManager.persist(ordenCobro);
	}

	@Override
	public OrdenCobro buscarPorEstado(String estado) {
		TypedQuery<OrdenCobro> myQuery = this.entityManager
				.createQuery("SELECT oc FROM OrdenCobro oc WHERE oc.estado = :datoEstado", OrdenCobro.class);
		myQuery.setParameter("datoEstado", estado);
		return myQuery.getSingleResult();
	}

	@Override
	public void actualizar(OrdenCobro ordenCobro) {
		this.entityManager.merge(ordenCobro);
	}

	@Override
	public void actualizarParcial(String estadoActual, String estadoNuevo) {
		Query myQuery = this.entityManager
				.createQuery("UPDATE OrdenCobro oc SET oc.estado = :datoEstado WHERE oc.estado =:datoCondicion");
		myQuery.setParameter("datoEstado", estadoNuevo);
		myQuery.setParameter("datoCondicion", estadoActual);
		myQuery.executeUpdate();

	}

	@Override
	public void borrar(Integer id) {
		this.entityManager.remove(this.buscarPorId(id));
	}

	@Override
	public List<OrdenCobro> buscarTodos(String estado) {
		TypedQuery<OrdenCobro> myQuery = this.entityManager
				.createQuery("SELECT oc FROM OrdenCobro oc WHERE oc.estado =:datoPEstado", OrdenCobro.class);
		myQuery.setParameter("datoPEstado", estado);
		return myQuery.getResultList();
	}

	@Override
	public OrdenCobro insertarOrdenCobro(OrdenCobro ordenCobro) {
		this.entityManager.persist(ordenCobro);
		return this.buscarPorEstado(ordenCobro.getEstado());
	}

}
