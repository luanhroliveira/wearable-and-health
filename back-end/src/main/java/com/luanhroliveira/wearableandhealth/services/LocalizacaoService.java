package com.luanhroliveira.wearableandhealth.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luanhroliveira.wearableandhealth.dto.LocalizacaoDTO;
import com.luanhroliveira.wearableandhealth.dto.LocalizacaoNewDTO;
import com.luanhroliveira.wearableandhealth.entitites.Localizacao;
import com.luanhroliveira.wearableandhealth.repositories.LocalizacaoRepository;
import com.luanhroliveira.wearableandhealth.services.exceptions.DataIntegrityException;

@Service
public class LocalizacaoService {

	@Autowired
	private LocalizacaoRepository localizacaoRepository;

	@Transactional(readOnly = true)
	public List<LocalizacaoDTO> findAll() {
		List<Localizacao> listLocalizacao = localizacaoRepository.findAll();
		return listLocalizacao.stream().map(x -> new LocalizacaoDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public Optional<LocalizacaoDTO> findById(Long id) {
		Optional<Localizacao> localizacao = localizacaoRepository.findById(id);
		return Optional.ofNullable(localizacao.map(x -> new LocalizacaoDTO(x)).get());
	}

	@Transactional
	public LocalizacaoNewDTO insert(LocalizacaoNewDTO dto) {
		try {
			Localizacao localizacao = new Localizacao(null, dto.getUsuario(), dto.getLatitude(), dto.getLongitude());
			localizacaoRepository.save(localizacao);
			return new LocalizacaoNewDTO(localizacao);
		} catch (DataIntegrityException e) {
			throw new DataIntegrityException(e.getMessage());
		}
	}

}
