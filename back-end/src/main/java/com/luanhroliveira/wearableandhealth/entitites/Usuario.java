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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import com.luanhroliveira.wearableandhealth.entitites.enums.Status;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(length = 120, nullable = false)
	private String nome;

	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@NotNull
	@CPF(message = "CPF inválido!")
	@CNPJ(message = "CNPJ inválido!")
	@Column(length = 20, unique = true, nullable = false)
	private String cpfCnpj;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(length = 20, columnDefinition = "varchar(20) default 'ATIVO'")
	private Status status;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ContatoUsuario> contatos = new HashSet<>();

	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<EnderecoUsuario> endereco = new HashSet<>();

	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Localizacao> localizacao = new HashSet<>();

	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Monitoramento> monitoramento = new HashSet<>();

	public Usuario() {
	}

	public Usuario(Long id, @NotNull String nome, @NotNull Date dataNascimento,
			@NotNull @CPF(message = "CPF inválido!") @CNPJ(message = "CNPJ inválido!") String cpfCnpj,
			@NotNull Status status, Set<ContatoUsuario> contatos, Set<EnderecoUsuario> endereco,
			Set<Localizacao> localizacao, Set<Monitoramento> monitoramento) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpfCnpj = cpfCnpj;
		this.status = status;
		this.contatos = contatos;
		this.endereco = endereco;
		this.localizacao = localizacao;
		this.monitoramento = monitoramento;
	}

	public Usuario(Long id, @NotNull String nome, @NotNull Date dataNascimento,
			@NotNull @CPF(message = "CPF inválido!") @CNPJ(message = "CNPJ inválido!") String cpfCnpj,
			@NotNull Status status) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpfCnpj = cpfCnpj;
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

	public Set<ContatoUsuario> getContatos() {
		return contatos;
	}

	public Set<EnderecoUsuario> getEndereco() {
		return endereco;
	}

	public Set<Localizacao> getLocalizacao() {
		return localizacao;
	}

	public Set<Monitoramento> getMonitoramento() {
		return monitoramento;
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
