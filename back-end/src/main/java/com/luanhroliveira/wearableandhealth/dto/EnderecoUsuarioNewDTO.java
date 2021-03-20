package com.luanhroliveira.wearableandhealth.dto;

import java.io.Serializable;

import com.luanhroliveira.wearableandhealth.entitites.Cidade;
import com.luanhroliveira.wearableandhealth.entitites.EnderecoUsuario;
import com.luanhroliveira.wearableandhealth.entitites.Usuario;

public class EnderecoUsuarioNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Usuario usuario;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private Cidade cidade;

	public EnderecoUsuarioNewDTO() {
	}

	public EnderecoUsuarioNewDTO(Long id, Usuario usuario, String logradouro, String numero, String complemento,
			String bairro, String cep, Cidade cidade) {
		this.id = id;
		this.usuario = usuario;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
	}

	public EnderecoUsuarioNewDTO(EnderecoUsuario entity) {
		id = entity.getId();
		usuario = entity.getUsuario();
		logradouro = entity.getLogradouro();
		numero = entity.getNumero();
		complemento = entity.getComplemento();
		bairro = entity.getBairro();
		cep = entity.getCep();
		cidade = entity.getCidade();
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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}
