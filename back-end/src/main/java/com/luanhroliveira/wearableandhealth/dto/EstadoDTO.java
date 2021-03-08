package com.luanhroliveira.wearableandhealth.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.luanhroliveira.wearableandhealth.entitites.Estado;

public class EstadoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String sigla;

	private List<CidadeDTO> cidades = new ArrayList<>();

	public EstadoDTO() {

	}

	public EstadoDTO(Long id, String nome, String sigla) {
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
	}

	public EstadoDTO(Estado entity) {
		id = entity.getId();
		nome = entity.getNome();
		sigla = entity.getSigla();

		cidades = entity.getCidades().stream().map(x -> new CidadeDTO(x)).collect(Collectors.toList());
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<CidadeDTO> getCidades() {
		return cidades;
	}

}
