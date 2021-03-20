package com.luanhroliveira.wearableandhealth.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luanhroliveira.wearableandhealth.dto.CidadeDTO;
import com.luanhroliveira.wearableandhealth.services.CidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;

	@GetMapping
	public ResponseEntity<List<CidadeDTO>> findAll() {
		List<CidadeDTO> listCidade = cidadeService.findAll();
		return ResponseEntity.ok().body(listCidade);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<CidadeDTO>> findById(@PathVariable Long id) {
		Optional<CidadeDTO> cidade = cidadeService.findById(id);
		return ResponseEntity.ok().body(cidade);
	}

	@PostMapping
	public ResponseEntity<CidadeDTO> insert(@RequestBody CidadeDTO dto) {
		dto = cidadeService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

}
