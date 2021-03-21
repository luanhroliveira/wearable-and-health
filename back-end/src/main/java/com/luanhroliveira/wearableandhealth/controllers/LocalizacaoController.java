package com.luanhroliveira.wearableandhealth.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luanhroliveira.wearableandhealth.dto.LocalizacaoDTO;
import com.luanhroliveira.wearableandhealth.dto.LocalizacaoNewDTO;
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

	@PostMapping
	public ResponseEntity<LocalizacaoNewDTO> insert(@Valid @RequestBody LocalizacaoNewDTO dto) {
		dto = localizacaoService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
}
