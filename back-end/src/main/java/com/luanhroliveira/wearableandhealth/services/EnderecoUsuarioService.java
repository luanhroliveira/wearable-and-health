package com.luanhroliveira.wearableandhealth.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luanhroliveira.wearableandhealth.dto.EnderecoUsuarioDTO;
import com.luanhroliveira.wearableandhealth.dto.EnderecoUsuarioNewDTO;
import com.luanhroliveira.wearableandhealth.entitites.EnderecoUsuario;
import com.luanhroliveira.wearableandhealth.entitites.enums.Status;
import com.luanhroliveira.wearableandhealth.repositories.EnderecoUsuarioRepository;
import com.luanhroliveira.wearableandhealth.services.exceptions.AuthorizationException;
import com.luanhroliveira.wearableandhealth.services.exceptions.DataIntegrityException;

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

	@Transactional
	public EnderecoUsuarioNewDTO insert(EnderecoUsuarioNewDTO dto) {
		try {
			EnderecoUsuario endereco = new EnderecoUsuario(null, dto.getUsuario(), dto.getCidade(), dto.getLogradouro(),
					dto.getNumero(), dto.getComplemento(), dto.getBairro(), dto.getCep(), Status.ATIVO);
			enderecoRepository.save(endereco);
			return new EnderecoUsuarioNewDTO(endereco);
		} catch (DataIntegrityException e) {
			throw new DataIntegrityException(e.getMessage());
		}
	}

	public EnderecoUsuarioDTO update(Long id, EnderecoUsuarioDTO dto) {
		try {
			EnderecoUsuario endereco = enderecoRepository.getOne(id);
			update(endereco, dto);
			enderecoRepository.save(endereco);
			return new EnderecoUsuarioDTO(endereco);
		} catch (AuthorizationException e) {
			throw new AuthorizationException(e.getMessage());
		} catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	private void update(EnderecoUsuario endereco, EnderecoUsuarioDTO dto) {
		endereco.setCep(dto.getCep());
		endereco.setLogradouro(dto.getLogradouro());
		endereco.setNumero(dto.getNumero());
		endereco.setBairro(dto.getBairro());
	}

	public void delete(Long id) {
		try {
			EnderecoUsuario endereco = enderecoRepository.getOne(id);
			if (endereco.getUsuario().getEnderecos().size() > 1) {
				enderecoRepository.deleteById(id);
			} else {
				throw new DataIntegrityException(
						"Necessário ao menos um contato para o usuário id.: " + endereco.getUsuario().getId());
			}
		} catch (DataIntegrityException e) {
			throw new DataIntegrityException(e.getMessage());
		}
	}
}
