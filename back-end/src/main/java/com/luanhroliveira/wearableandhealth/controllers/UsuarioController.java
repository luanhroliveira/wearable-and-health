package com.luanhroliveira.wearableandhealth.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.luanhroliveira.wearableandhealth.dto.UsuarioDTO;
import com.luanhroliveira.wearableandhealth.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<UsuarioDTO> listUsuario = usuarioService.findAll();
		return ResponseEntity.ok().body(listUsuario);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<UsuarioDTO>> findById(@PathVariable Long id) {
		Optional<UsuarioDTO> usuario = Optional.ofNullable(usuarioService.findById(id));
		return ResponseEntity.ok().body(usuario);
	}

	@PostMapping
	public ResponseEntity<UsuarioDTO> insert(@RequestBody UsuarioDTO dto) {
		dto = usuarioService.insert(dto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping("{id}")
	public ResponseEntity<UsuarioDTO> update(@PathVariable Long id, @RequestBody UsuarioDTO dto) {
		dto = usuarioService.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
}
