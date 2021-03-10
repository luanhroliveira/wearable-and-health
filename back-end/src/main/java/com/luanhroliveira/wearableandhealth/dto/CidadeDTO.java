package com.luanhroliveira.wearableandhealth.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.luanhroliveira.wearableandhealth.entitites.Cidade;
import com.luanhroliveira.wearableandhealth.entitites.Estado;

public class CidadeDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Estado estado;

	private List<EnderecoUsuarioDTO> enderecos = new ArrayList<>();

	public CidadeDTO() {
	}

	public CidadeDTO(Long id, String nome, Estado estado) {
		this.id = id;
		this.nome = nome;
		this.estado = estado;
	}

	public CidadeDTO(Cidade entity) {
		id = entity.getId();
		nome = entity.getNome();
		estado = entity.getEstado();
		enderecos = entity.getEnderecos().stream().map(x -> new EnderecoUsuarioDTO(x)).collect(Collectors.toList());
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<EnderecoUsuarioDTO> getEnderecos() {
		return enderecos;
	}

}
