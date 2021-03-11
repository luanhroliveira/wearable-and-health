package com.luanhroliveira.wearableandhealth.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luanhroliveira.wearableandhealth.dto.ContatoUsuarioDTO;
import com.luanhroliveira.wearableandhealth.entitites.ContatoUsuario;
import com.luanhroliveira.wearableandhealth.repositories.ContatoUsuarioRepository;

@Service
public class ContatoUsuarioService {

	@Autowired
	private ContatoUsuarioRepository contatoRepository;

	@Transactional(readOnly = true)
	public List<ContatoUsuarioDTO> findAll() {
		List<ContatoUsuario> listContato = contatoRepository.findAll();
		return listContato.stream().map(x -> new ContatoUsuarioDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public Optional<ContatoUsuarioDTO> findById(Long id) {
		Optional<ContatoUsuario> listContato = contatoRepository.findById(id);
		return Optional.ofNullable(listContato.map(x -> new ContatoUsuarioDTO(x)).get());
	}

}
