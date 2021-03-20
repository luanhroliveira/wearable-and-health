package com.luanhroliveira.wearableandhealth.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luanhroliveira.wearableandhealth.dto.EstadoDTO;
import com.luanhroliveira.wearableandhealth.entitites.Estado;
import com.luanhroliveira.wearableandhealth.repositories.EstadoRepository;
import com.luanhroliveira.wearableandhealth.services.exceptions.DataIntegrityException;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;

	@Transactional(readOnly = true)
	public List<EstadoDTO> findAll() {
		List<Estado> listEstado = estadoRepository.findAll();
		return listEstado.stream().map(x -> new EstadoDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public Optional<EstadoDTO> findById(Long id) {
		Optional<Estado> estado = estadoRepository.findById(id);
		return Optional.ofNullable(estado.map(x -> new EstadoDTO(x)).get());
	}

	@Transactional
	public EstadoDTO insert(EstadoDTO dto) {
		try {
			Estado estado = new Estado(null, dto.getNome(), dto.getSigla());
			estado = estadoRepository.save(estado);
			return new EstadoDTO(estado);
		} catch (DataIntegrityException e) {
			throw new DataIntegrityException(e.getMessage());
		}
	}

	public void delete(Long id) {
		try {
			estadoRepository.deleteById(id);
		} catch (DataIntegrityException e) {
			throw new DataIntegrityException(e.getMessage());
		}
	}
}
