package com.luanhroliveira.wearableandhealth.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luanhroliveira.wearableandhealth.entitites.Cidade;
import com.luanhroliveira.wearableandhealth.entitites.EnderecoUsuario;
import com.luanhroliveira.wearableandhealth.entitites.Usuario;

public class EnderecoUsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private Usuario usuario;

	@NotEmpty(message = "Logradouro não pode estar vazio.")
	@Length(min = 5, max = 120)
	private String logradouro;
	@NotEmpty(message = "Número do logradouro não pode estar vazio.")
	@Length(min = 1, max = 20)
	private String numero;
	private String complemento;
	@NotEmpty(message = "Bairro não pode estar vazio.")
	@Length(min = 5, max = 64)
	private String bairro;
	@NotEmpty(message = "Logradouro não pode estar vazio.")
	@Length(min = 8, max = 9)
	private String cep;

	private Cidade cidade;

	public EnderecoUsuarioDTO() {
	}

	public EnderecoUsuarioDTO(Usuario usuario, String logradouro, String numero, String complemento, String bairro,
			String cep, Cidade cidade) {
		this.usuario = usuario;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
	}

	public EnderecoUsuarioDTO(EnderecoUsuario entity) {
		usuario = entity.getUsuario();
		logradouro = entity.getLogradouro();
		numero = entity.getNumero();
		complemento = entity.getComplemento();
		bairro = entity.getBairro();
		cep = entity.getCep();
		cidade = entity.getCidade();
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
