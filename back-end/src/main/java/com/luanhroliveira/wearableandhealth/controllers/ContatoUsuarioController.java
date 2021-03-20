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

import com.luanhroliveira.wearableandhealth.dto.ContatoUsuarioDTO;
import com.luanhroliveira.wearableandhealth.dto.ContatoUsuarioNewDTO;
import com.luanhroliveira.wearableandhealth.services.ContatoUsuarioService;

@RestController
@RequestMapping(value = "/contatos")
public class ContatoUsuarioController {

	@Autowired
	private ContatoUsuarioService contatoService;

	@GetMapping
	public ResponseEntity<List<ContatoUsuarioDTO>> findAll() {
		List<ContatoUsuarioDTO> listContato = contatoService.findAll();
		return ResponseEntity.ok().body(listContato);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<ContatoUsuarioDTO>> findById(@PathVariable Long id) {
		Optional<ContatoUsuarioDTO> contato = contatoService.findById(id);
		return ResponseEntity.ok().body(contato);
	}

	@PostMapping
	public ResponseEntity<ContatoUsuarioNewDTO> insert(@Valid @RequestBody ContatoUsuarioNewDTO dto) {
		dto = contatoService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
}
