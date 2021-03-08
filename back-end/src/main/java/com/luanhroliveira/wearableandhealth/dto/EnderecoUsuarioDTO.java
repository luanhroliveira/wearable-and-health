package com.luanhroliveira.wearableandhealth.dto;

import java.io.Serializable;

import com.luanhroliveira.wearableandhealth.entitites.Cidade;
import com.luanhroliveira.wearableandhealth.entitites.EnderecoUsuario;
import com.luanhroliveira.wearableandhealth.entitites.Usuario;

public class EnderecoUsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Usuario usuario;
	private Cidade cidade;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;

	public EnderecoUsuarioDTO() {
	}

	public EnderecoUsuarioDTO(Long id, Usuario usuario, Cidade cidade, String logradouro, String numero,
			String complemento, String bairro, String cep) {
		this.id = id;
		this.usuario = usuario;
		this.cidade = cidade;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
	}

	public EnderecoUsuarioDTO(EnderecoUsuario entity) {
		id = entity.getId();
		usuario = entity.getUsuario();
		cidade = entity.getCidade();
		logradouro = entity.getLogradouro();
		numero = entity.getNumero();
		complemento = entity.getComplemento();
		bairro = entity.getBairro();
		cep = entity.getCep();
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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
