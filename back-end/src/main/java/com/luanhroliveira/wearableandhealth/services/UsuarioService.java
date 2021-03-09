package com.luanhroliveira.wearableandhealth.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luanhroliveira.wearableandhealth.dto.UsuarioDTO;
import com.luanhroliveira.wearableandhealth.entitites.Usuario;
import com.luanhroliveira.wearableandhealth.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional(readOnly = true)
	public List<UsuarioDTO> findAll() {
		List<Usuario> listUsuario = usuarioRepository.findAll();
		return listUsuario.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public UsuarioDTO findById(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.map(x -> new UsuarioDTO(x)).get();
	}
	
}
