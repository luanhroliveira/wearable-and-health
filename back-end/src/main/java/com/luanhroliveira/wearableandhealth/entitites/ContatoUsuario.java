package com.luanhroliveira.wearableandhealth.entitites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luanhroliveira.wearableandhealth.entitites.enums.Status;

@Entity
@Table(name = "contato_usuario")
public class ContatoUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;

	@NotNull
	@Column(length = 120, nullable = false)
	private String nome;

	@NotNull
	@Column(length = 14, nullable = false)
	private String telefone;

	@NotNull
	@Email(message = "Email inválido!")
	@Column(length = 120)
	private String email;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(length = 20, columnDefinition = "varchar(20) default 'ATIVO'")
	private Status status;

	public ContatoUsuario() {

	}

	public ContatoUsuario(Long id, Usuario usuario, @NotNull String nome, @NotNull String telefone,
			@NotNull @Email(message = "Email inválido!") String email, @NotNull Status status) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
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

	public Usuario getUsuario() {
		return usuario;
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
		ContatoUsuario other = (ContatoUsuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
