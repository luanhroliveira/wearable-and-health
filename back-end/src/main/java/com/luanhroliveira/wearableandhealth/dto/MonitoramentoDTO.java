package com.luanhroliveira.wearableandhealth.dto;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luanhroliveira.wearableandhealth.entitites.Monitoramento;
import com.luanhroliveira.wearableandhealth.entitites.Sensor;
import com.luanhroliveira.wearableandhealth.entitites.Usuario;

public class MonitoramentoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@JsonIgnore
	private Usuario usuario;
	private Sensor sensor;
	private Instant momento;

	public MonitoramentoDTO() {

	}

	public MonitoramentoDTO(Long id, Usuario usuario, Sensor sensor, Instant momento) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.sensor = sensor;
		this.momento = momento;
	}

	public MonitoramentoDTO(Monitoramento entity) {
		id = entity.getId();
		usuario = entity.getUsuario();
		sensor = entity.getSensor();
		momento = entity.getMomento();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

}
