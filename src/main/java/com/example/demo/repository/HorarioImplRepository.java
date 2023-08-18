package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.modelo.Horario;

@Repository
@Transactional
public class HorarioImplRepository implements IHorarioRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Horario buscarPorId(Integer id) {
		return this.entityManager.find(Horario.class, id);
	}

	@Override
	public Horario seleccionarPorMateria(String materia) {
		TypedQuery<Horario> myQuery = this.entityManager
				.createQuery("SELECT h FROM Horario h WHERE h.materia = :datoMateria", Horario.class);
		myQuery.setParameter("datoMateria", materia);
		return myQuery.getSingleResult();
	}

	@Override
	public void insertar(Horario horario) {
		this.entityManager.persist(horario);
	}

	@Override
	public void actualizar(Horario horario) {
		this.entityManager.merge(horario);
	}

	@Override
	public void actualizarParcial(String materiaActual, String materiaNueva) {
		Query myQuery = this.entityManager
				.createQuery("UPDATE Horario h SET h.materia = :datoMateria WHERE h.materia =:datoCondicion");
		myQuery.setParameter("datoMateria", materiaNueva);
		myQuery.setParameter("datoCondicion", materiaActual);
		myQuery.executeUpdate();
	}

	@Override
	public void borrar(Integer id) {
		this.entityManager.remove(this.buscarPorId(id));
	}

	@Override
	public List<Horario> buscarTodos(String dia) {
		TypedQuery<Horario> myQuery = this.entityManager.createQuery("SELECT h FROM Horario h WHERE h.dia =:datoDia",
				Horario.class);
		myQuery.setParameter("datoDia", dia);
		return myQuery.getResultList();
	}

}
