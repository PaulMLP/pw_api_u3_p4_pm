package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "orden_cobro")
public class OrdenCobro {

	@Id
	@Column(name = "orco_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_orden_cobro")
	@SequenceGenerator(name = "seq_orden_cobro", sequenceName = "seq_orden_cobro", allocationSize = 1)
	private Integer id;

	@Column(name = "orco_fecha")
	private LocalDateTime fecha;

	@Column(name = "orco_monto")
	private BigDecimal monto;

	@Column(name = "orco_estado")
	private String estado;

	@Column(name = "orco_detalle")
	private String detalle;

	// Getters y Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

}