package com.luanhroliveira.wearableandhealth.dto;

import java.io.Serializable;
import java.time.Instant;

import com.luanhroliveira.wearableandhealth.entitites.Localizacao;
import com.luanhroliveira.wearableandhealth.entitites.Usuario;

public class LocalizacaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Usuario usuario;
	private Double latitude;
	private Double longitude;
	private Instant momento;

	public LocalizacaoDTO() {

	}

	public LocalizacaoDTO(Long id, Usuario usuario, Double latitude, Double longitude, Instant momento) {
		this.id = id;
		this.usuario = usuario;
		this.latitude = latitude;
		this.longitude = longitude;
		this.momento = momento;
	}

	public LocalizacaoDTO(Localizacao entity) {
		id = entity.getId();
		usuario = entity.getUsuario();
		latitude = entity.getLatitude();
		longitude = entity.getLongitude();
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

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

}
