package com.luanhroliveira.wearableandhealth.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luanhroliveira.wearableandhealth.dto.LocalizacaoDTO;
import com.luanhroliveira.wearableandhealth.services.LocalizacaoService;

@RestController
@RequestMapping(value = "/localizacoes")
public class LocalizacaoController {

	@Autowired
	private LocalizacaoService localizacaoService;

	@GetMapping
	public ResponseEntity<List<LocalizacaoDTO>> findAll() {
		List<LocalizacaoDTO> listLocalizacao = localizacaoService.findAll();
		return ResponseEntity.ok().body(listLocalizacao);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<LocalizacaoDTO>> findById(@PathVariable Long id) {
		Optional<LocalizacaoDTO> localizacao = localizacaoService.findById(id);
		return ResponseEntity.ok().body(localizacao);
	}

}
