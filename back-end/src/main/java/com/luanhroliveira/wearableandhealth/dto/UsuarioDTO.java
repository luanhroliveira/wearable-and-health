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
	private String cpfCnpj;
	private Status status;

	private List<ContatoUsuarioDTO> contatos = new ArrayList<>();
	private List<EnderecoUsuarioDTO> enderecos = new ArrayList<>();
	private List<LocalizacaoDTO> localizacao = new ArrayList<>();
	private List<MonitoramentoDTO> monitoramento = new ArrayList<>();

	public UsuarioDTO() {

	}

	public UsuarioDTO(Long id, String nome, Date dataNascimento, String cpfCnpj, Status status) {
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpfCnpj = cpfCnpj;
		this.status = status;
	}

	public UsuarioDTO(Usuario entity) {
		id = entity.getId();
		nome = entity.getNome();
		dataNascimento = entity.getDataNascimento();
		cpfCnpj = entity.getCpfCnpj();
		status = entity.getStatus();

		contatos = entity.getContatos().stream().map(x -> new ContatoUsuarioDTO(x)).collect(Collectors.toList());
		enderecos = entity.getEndereco().stream().map(x -> new EnderecoUsuarioDTO(x)).collect(Collectors.toList());
		localizacao = entity.getLocalizacao().stream().map(x -> new LocalizacaoDTO(x)).collect(Collectors.toList());
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
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
