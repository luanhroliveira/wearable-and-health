package com.luanhroliveira.wearableandhealth.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luanhroliveira.wearableandhealth.dto.CidadeDTO;
import com.luanhroliveira.wearableandhealth.entitites.Cidade;
import com.luanhroliveira.wearableandhealth.repositories.CidadeRepository;
import com.luanhroliveira.wearableandhealth.services.exceptions.DataIntegrityException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Transactional(readOnly = true)
	public List<CidadeDTO> findAll() {
		List<Cidade> listCidade = cidadeRepository.findAll();
		return listCidade.stream().map(x -> new CidadeDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public Optional<CidadeDTO> findById(Long id) {
		Optional<Cidade> cidade = cidadeRepository.findById(id);
		return Optional.ofNullable(cidade.map(x -> new CidadeDTO(x)).get());
	}

	public CidadeDTO insert(CidadeDTO dto) {
		try {
			Cidade cidade = new Cidade(null, dto.getEstado(), dto.getNome());
			cidadeRepository.save(cidade);
			return new CidadeDTO(cidade);
		} catch (DataIntegrityException e) {
			throw new DataIntegrityException(e.getMessage());
		}
	}

}
