package com.luanhroliveira.wearableandhealth.entitites;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.luanhroliveira.wearableandhealth.entitites.enums.Status;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 120, nullable = false)
	private String nome;

	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Column(length = 14, unique = true, nullable = false)
	private String cpf;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "varchar default 'ATIVO'")
	private Status status;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ContatoUsuario> contatos = new HashSet<>();

	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<EnderecoUsuario> enderecos = new HashSet<>();

	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Localizacao> localizacoes = new HashSet<>();

	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private Set<Monitoramento> monitoramentos = new HashSet<>();

	public Usuario() {
	}

	public Usuario(Long id, String nome, Date dataNascimento, String cpf, Status status, Set<ContatoUsuario> contatos,
			Set<EnderecoUsuario> enderecos, Set<Localizacao> localizacoes, Set<Monitoramento> monitoramentos) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.status = status;
		this.contatos = contatos;
		this.enderecos = enderecos;
		this.localizacoes = localizacoes;
		this.monitoramentos = monitoramentos;
	}

	public Usuario(Long id, String nome, Date dataNascimento, String cpf, Status status) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.status = status;
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

	public Set<ContatoUsuario> getContatos() {
		return contatos;
	}

	public Set<EnderecoUsuario> getEnderecos() {
		return enderecos;
	}

	public Set<Localizacao> getLocalizacoes() {
		return localizacoes;
	}

	public Set<Monitoramento> getMonitoramentos() {
		return monitoramentos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
