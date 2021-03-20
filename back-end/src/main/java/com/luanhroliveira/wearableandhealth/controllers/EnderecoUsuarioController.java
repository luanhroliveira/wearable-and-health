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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luanhroliveira.wearableandhealth.dto.EnderecoUsuarioDTO;
import com.luanhroliveira.wearableandhealth.dto.EnderecoUsuarioNewDTO;
import com.luanhroliveira.wearableandhealth.services.EnderecoUsuarioService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoUsuarioController {

	@Autowired
	private EnderecoUsuarioService enderecoService;

	@GetMapping
	public ResponseEntity<List<EnderecoUsuarioDTO>> findAll() {
		List<EnderecoUsuarioDTO> enderecos = enderecoService.findAll();
		return ResponseEntity.ok().body(enderecos);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<EnderecoUsuarioDTO>> findById(@PathVariable Long id) {
		Optional<EnderecoUsuarioDTO> endereco = enderecoService.findById(id);
		return ResponseEntity.ok().body(endereco);
	}

	@PostMapping
	public ResponseEntity<EnderecoUsuarioNewDTO> insert(@Valid @RequestBody EnderecoUsuarioNewDTO dto) {
		dto = enderecoService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<EnderecoUsuarioDTO> update(@PathVariable Long id,
			@Valid @RequestBody EnderecoUsuarioDTO dto) {
		dto = enderecoService.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
}
