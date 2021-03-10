package com.luanhroliveira.wearableandhealth.dto;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luanhroliveira.wearableandhealth.entitites.Monitoramento;
import com.luanhroliveira.wearableandhealth.entitites.Usuario;

public class MonitoramentoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@JsonIgnore
	private Usuario usuario;
	private Integer qtPassos;
	private Double saturacaoSanguinea;
	private Double batimentoCardio;
	private Double oximetro;
	private Instant momento;

	public MonitoramentoDTO() {

	}

	public MonitoramentoDTO(Long id, Usuario usuario, Integer qtPassos, Double saturacaoSanguinea,
			Double batimentoCardio, Double oximetro, Instant momento) {
		this.id = id;
		this.usuario = usuario;
		this.qtPassos = qtPassos;
		this.saturacaoSanguinea = saturacaoSanguinea;
		this.batimentoCardio = batimentoCardio;
		this.oximetro = oximetro;
		this.momento = momento;
	}

	public MonitoramentoDTO(Monitoramento entity) {
		id = entity.getId();
		usuario = entity.getUsuario();
		qtPassos = entity.getQtPassos();
		saturacaoSanguinea = entity.getSaturacaoSanguinea();
		batimentoCardio = entity.getBatimentoCardio();
		oximetro = entity.getOximetro();
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

	public Integer getQtPassos() {
		return qtPassos;
	}

	public void setQtPassos(Integer qtPassos) {
		this.qtPassos = qtPassos;
	}

	public Double getSaturacaoSanguinea() {
		return saturacaoSanguinea;
	}

	public void setSaturacaoSanguinea(Double saturacaoSanguinea) {
		this.saturacaoSanguinea = saturacaoSanguinea;
	}

	public Double getBatimentoCardio() {
		return batimentoCardio;
	}

	public void setBatimentoCardio(Double batimentoCardio) {
		this.batimentoCardio = batimentoCardio;
	}

	public Double getOximetro() {
		return oximetro;
	}

	public void setOximetro(Double oximetro) {
		this.oximetro = oximetro;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

}
