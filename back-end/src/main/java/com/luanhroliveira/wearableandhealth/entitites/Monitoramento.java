package com.luanhroliveira.wearableandhealth.entitites;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "monitoramento")
public class Monitoramento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;

	private Integer qtPassos;
	private Double saturacaoSanguinea;
	private Double batimentoCardio;
	private Double oximetro;

	@NotNull
	@CreationTimestamp
	private Instant momento;

	public Monitoramento() {
	}

	public Monitoramento(Long id, Usuario usuario, Integer qtPassos, Double saturacaoSanguinea, Double batimentoCardio,
			Double oximetro, @NotNull Instant momento) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.qtPassos = qtPassos;
		this.saturacaoSanguinea = saturacaoSanguinea;
		this.batimentoCardio = batimentoCardio;
		this.oximetro = oximetro;
		this.momento = momento;
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

	public Integer getQtPassos() {
		return qtPassos;
	}

	public void setQtPassos(Integer qtPassos) {
		this.qtPassos = qtPassos;
	}

	public Double getSaturacaoSanguinea() {
		return saturacaoSanguinea;
	}

	public void setSaturacaoSanguinea(Double saturacaoSanguinea) {
		this.saturacaoSanguinea = saturacaoSanguinea;
	}

	public Double getBatimentoCardio() {
		return batimentoCardio;
	}

	public void setBatimentoCardio(Double batimentoCardio) {
		this.batimentoCardio = batimentoCardio;
	}

	public Double getOximetro() {
		return oximetro;
	}

	public void setOximetro(Double oximetro) {
		this.oximetro = oximetro;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
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
		Monitoramento other = (Monitoramento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
