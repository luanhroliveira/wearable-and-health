package com.luanhroliveira.wearableandhealth.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luanhroliveira.wearableandhealth.dto.LocalizacaoDTO;
import com.luanhroliveira.wearableandhealth.entitites.Localizacao;
import com.luanhroliveira.wearableandhealth.repositories.LocalizacaoRepository;

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

}
