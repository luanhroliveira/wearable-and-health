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
	private Estado estado;
	private String nome;

	private List<EnderecoUsuarioDTO> enderecos = new ArrayList<>();

	public CidadeDTO() {
	}

	public CidadeDTO(Long id, Estado estado, String nome) {
		this.id = id;
		this.estado = estado;
		this.nome = nome;
	}

	public CidadeDTO(Cidade entity) {
		id = entity.getId();
		estado = entity.getEstado();
		nome = entity.getNome();

		enderecos = entity.getEnderecos().stream().map(x -> new EnderecoUsuarioDTO(x)).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<EnderecoUsuarioDTO> getEnderecos() {
		return enderecos;
	}

}
