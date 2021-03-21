package com.luanhroliveira.wearableandhealth.entitites;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "monitoramento")
public class Monitoramento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "sensor_id", nullable = false)
	private Sensor sensor;

	private Double valorSensorDouble;
	private String valorSensorString;
	private Boolean valorSensorBoolean;

	@CreationTimestamp
	@Column(columnDefinition = "datetime default current_timestamp")
	private Instant momento;

	public Monitoramento() {
	}

	public Monitoramento(Long id, Usuario usuario, Sensor sensor, Double valorSensorDouble, String valorSensorString,
			Boolean valorSensorBoolean) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.sensor = sensor;
		this.valorSensorDouble = valorSensorDouble;
		this.valorSensorString = valorSensorString;
		this.valorSensorBoolean = valorSensorBoolean;
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

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Monitoramento other = (Monitoramento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
