package com.luanhroliveira.wearableandhealth.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.luanhroliveira.wearableandhealth.entitites.Usuario;
import com.luanhroliveira.wearableandhealth.entitites.enums.Status;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Date dataNascimento;
	private String cpf;
	private Status status;

	private List<ContatoUsuarioDTO> contatos = new ArrayList<>();
	private List<EnderecoUsuarioDTO> enderecos = new ArrayList<>();
	private List<LocalizacaoDTO> localizacao = new ArrayList<>();
	private List<MonitoramentoDTO> monitoramento = new ArrayList<>();

	public UsuarioDTO() {

	}

	public UsuarioDTO(Long id, String nome, Date dataNascimento, String cpf, Status status) {
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.status = status;
	}

	public UsuarioDTO(Usuario entity) {
		id = entity.getId();
		nome = entity.getNome();
		dataNascimento = entity.getDataNascimento();
		cpf = entity.getCpf();
		status = entity.getStatus();

		contatos = entity.getContatos().stream().map(x -> new ContatoUsuarioDTO(x)).collect(Collectors.toList());
		enderecos = entity.getEnderecos().stream().map(x -> new EnderecoUsuarioDTO(x)).collect(Collectors.toList());
		localizacao = entity.getLocalizacoes().stream().map(x -> new LocalizacaoDTO(x)).collect(Collectors.toList());
		monitoramento = entity.getMonitoramentos().stream().map(x -> new MonitoramentoDTO(x))
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

	public List<ContatoUsuarioDTO> getContatos() {
		return contatos;
	}

	public List<EnderecoUsuarioDTO> getEnderecos() {
		return enderecos;
	}

	public List<LocalizacaoDTO> getLocalizacao() {
		return localizacao;
	}

	public List<MonitoramentoDTO> getMonitoramento() {
		return monitoramento;
	}

}
