package com.luanhroliveira.wearableandhealth.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luanhroliveira.wearableandhealth.entitites.ContatoUsuario;
import com.luanhroliveira.wearableandhealth.entitites.Usuario;
import com.luanhroliveira.wearableandhealth.entitites.enums.Status;

public class ContatoUsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@JsonIgnore
	private Usuario usuario;
	private String nome;
	private String telefone;
	private String email;
	private Status status;

	public ContatoUsuarioDTO() {
	}

	public ContatoUsuarioDTO(Long id, Usuario usuario, String nome, String telefone, String email, Status status) {
		this.id = id;
		this.usuario = usuario;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.status = status;
	}

	public ContatoUsuarioDTO(ContatoUsuario entity) {
		id = entity.getId();
		usuario = entity.getUsuario();
		nome = entity.getNome();
		telefone = entity.getTelefone();
		email = entity.getEmail();
		status = entity.getStatus();
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
