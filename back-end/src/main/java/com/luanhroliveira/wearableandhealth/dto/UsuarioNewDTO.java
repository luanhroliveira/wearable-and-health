package com.luanhroliveira.wearableandhealth.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.luanhroliveira.wearableandhealth.entitites.Usuario;
import com.luanhroliveira.wearableandhealth.entitites.enums.Status;

public class UsuarioNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotEmpty(message = "Preenchimento obrigatório.")
	@Length(min = 5, max = 120, message = "Nome deve conter de 5 a 120 caracteres.")
	private String nome;
	private Date dataNascimento;
	@NotEmpty(message = "Preenchimento obrigatório.")
	@CPF(message = "CPF inválido!")
	private String cpf;
	private Status status;

	private List<ContatoUsuarioNewDTO> contatos = new ArrayList<>();
	private List<EnderecoUsuarioNewDTO> enderecos = new ArrayList<>();

	public UsuarioNewDTO() {

	}

	public UsuarioNewDTO(Long id, String nome, Date dataNascimento, String cpf, Status status) {
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.status = status;
	}

	public UsuarioNewDTO(Usuario entity) {
		id = entity.getId();
		nome = entity.getNome();
		dataNascimento = entity.getDataNascimento();
		cpf = entity.getCpf();
		status = entity.getStatus();

		contatos = entity.getContatos().stream().map(x -> new ContatoUsuarioNewDTO(x)).collect(Collectors.toList());
		enderecos = entity.getEnderecos().stream().map(x -> new EnderecoUsuarioNewDTO(x)).collect(Collectors.toList());
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<ContatoUsuarioNewDTO> getContatos() {
		return contatos;
	}

	public List<EnderecoUsuarioNewDTO> getEnderecos() {
		return enderecos;
	}

}
