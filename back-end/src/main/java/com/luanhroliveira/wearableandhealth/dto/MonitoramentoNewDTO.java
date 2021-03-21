package com.luanhroliveira.wearableandhealth.dto;

import java.io.Serializable;
import java.time.Instant;

import com.luanhroliveira.wearableandhealth.entitites.Monitoramento;
import com.luanhroliveira.wearableandhealth.entitites.Sensor;
import com.luanhroliveira.wearableandhealth.entitites.Usuario;

public class MonitoramentoNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Usuario usuario;
	private Sensor sensor;
	private Instant momento;
	private Double valorSensorDouble;
	private String valorSensorString;
	private Boolean valorSensorBoolean;

	public MonitoramentoNewDTO() {

	}

	public MonitoramentoNewDTO(Long id, Usuario usuario, Sensor sensor, Instant momento, Double valorSensorDouble,
			String valorSensorString, Boolean valorSensorBoolean) {
		this.id = id;
		this.usuario = usuario;
		this.sensor = sensor;
		this.momento = momento;
		this.valorSensorDouble = valorSensorDouble;
		this.valorSensorString = valorSensorString;
		this.valorSensorBoolean = valorSensorBoolean;
	}

	public MonitoramentoNewDTO(Monitoramento entity) {
		id = entity.getId();
		usuario = entity.getUsuario();
		sensor = entity.getSensor();
		momento = entity.getMomento();
		valorSensorDouble = entity.getValorSensorDouble();
		valorSensorString = entity.getValorSensorString();
		valorSensorBoolean = entity.getValorSensorBoolean();
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

	public Double getValorSensorDouble() {
		return valorSensorDouble;
	}

	public void setValorSensorDouble(Double valorSensorDouble) {
		this.valorSensorDouble = valorSensorDouble;
	}

	public String getValorSensorString() {
		return valorSensorString;
	}

	public void setValorSensorString(String valorSensorString) {
		this.valorSensorString = valorSensorString;
	}

	public Boolean getValorSensorBoolean() {
		return valorSensorBoolean;
	}

	public void setValorSensorBoolean(Boolean valorSensorBoolean) {
		this.valorSensorBoolean = valorSensorBoolean;
	}

}
