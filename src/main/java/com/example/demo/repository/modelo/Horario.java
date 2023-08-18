package com.example.demo.repository.modelo;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "horario")
public class Horario {

	@Id
	@Column(name = "hori_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_horario")
	@SequenceGenerator(name = "seq_horario", sequenceName = "seq_horario", allocationSize = 1)
	private Integer id;

	@Column(name = "hori_dia")
	private String dia;

	@Column(name = "hori_materia")
	private String materia;

	@Column(name = "hori_horaInicio")
	private LocalTime horaInicio;

	@Column(name = "hori_horaFin")
	private LocalTime horaFin;

	// GET y SET

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	@Column(name = "hori_aula")
	private String aula;

	// SET y GET

}
