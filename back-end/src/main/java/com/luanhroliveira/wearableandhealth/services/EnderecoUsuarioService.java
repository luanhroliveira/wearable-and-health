package com.luanhroliveira.wearableandhealth.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luanhroliveira.wearableandhealth.dto.EnderecoUsuarioDTO;
import com.luanhroliveira.wearableandhealth.entitites.EnderecoUsuario;
import com.luanhroliveira.wearableandhealth.repositories.EnderecoUsuarioRepository;

@Service
public class EnderecoUsuarioService {

	@Autowired
	private EnderecoUsuarioRepository enderecoRepository;

	@Transactional(readOnly = true)
	public List<EnderecoUsuarioDTO> findAll() {
		List<EnderecoUsuario> enderecos = enderecoRepository.findAll();
		return enderecos.stream().map(x -> new EnderecoUsuarioDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public Optional<EnderecoUsuarioDTO> findById(Long id) {
		Optional<EnderecoUsuario> endereco = enderecoRepository.findById(id);
		return Optional.ofNullable(endereco.map(x -> new EnderecoUsuarioDTO(x)).get());
	}
}
