package com.luanhroliveira.wearableandhealth.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luanhroliveira.wearableandhealth.dto.ContatoUsuarioDTO;
import com.luanhroliveira.wearableandhealth.dto.ContatoUsuarioNewDTO;
import com.luanhroliveira.wearableandhealth.entitites.ContatoUsuario;
import com.luanhroliveira.wearableandhealth.entitites.enums.Status;
import com.luanhroliveira.wearableandhealth.repositories.ContatoUsuarioRepository;
import com.luanhroliveira.wearableandhealth.services.exceptions.AuthorizationException;
import com.luanhroliveira.wearableandhealth.services.exceptions.DataIntegrityException;

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

	@Transactional
	public ContatoUsuarioNewDTO insert(ContatoUsuarioNewDTO dto) {
		try {
			ContatoUsuario contato = new ContatoUsuario(null, dto.getUsuario(), dto.getNome(), dto.getTelefone(),
					dto.getEmail(), Status.ATIVO);
			contato = contatoRepository.save(contato);
			return new ContatoUsuarioNewDTO(contato);
		} catch (DataIntegrityException e) {
			throw new DataIntegrityException(e.getMessage());
		}
	}

	public ContatoUsuarioDTO update(Long id, ContatoUsuarioDTO dto) {
		try {
			ContatoUsuario contato = contatoRepository.getOne(id);
			update(contato, dto);
			contato = contatoRepository.save(contato);
			return new ContatoUsuarioDTO(contato);
		} catch (AuthorizationException e) {
			throw new AuthorizationException(e.getMessage());
		} catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	private void update(ContatoUsuario contato, ContatoUsuarioDTO dto) {
		contato.setNome(dto.getNome());
		contato.setTelefone(dto.getTelefone());
		contato.setEmail(dto.getEmail());
	}

	public void delete(Long id) {
		try {
			ContatoUsuario contato = contatoRepository.getOne(id);
			if (contato.getUsuario().getContatos().size() > 1) {
				contatoRepository.deleteById(id);
			} else {
				throw new DataIntegrityException("Impossível deletar, usuário necessita ao menos um contato.");
			}
		} catch (DataIntegrityException e) {
			throw new DataIntegrityException(e.getMessage());
		}
	}
}
