package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.modelo.Materia;

@Repository
@Transactional
public class MateriaImplRepository implements IMateriaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Materia seleccionarPorId(Integer id) {
		TypedQuery<Materia> myQuery = this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.id = :datoId",
				Materia.class);
		myQuery.setParameter("datoId", id);
		return myQuery.getSingleResult();
	}

	@Override
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);
	}

	@Override
	public List<Materia> buscarPorCedulaEstudiante(String cedula) {
		TypedQuery<Materia> myQuery = this.entityManager
				.createQuery("SELECT m FROM Materia m WHERE m.estudiante.cedula =:datoCedula", Materia.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getResultList();
	}

}
