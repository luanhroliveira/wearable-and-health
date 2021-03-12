package com.luanhroliveira.wearableandhealth.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.luanhroliveira.wearableandhealth.entitites.Sensor;

public class SensorDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;

	private List<MonitoramentoDTO> monitoramento = new ArrayList<>();

	public SensorDTO() {

	}

	public SensorDTO(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public SensorDTO(Sensor entity) {
		id = entity.getId();
		nome = entity.getNome();

		monitoramento = entity.getMonitoramento().stream().map(x -> new MonitoramentoDTO(x))
				.collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<MonitoramentoDTO> getMonitoramento() {
		return monitoramento;
	}

}
