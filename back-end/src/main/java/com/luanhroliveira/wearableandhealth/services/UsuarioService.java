package com.luanhroliveira.wearableandhealth.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luanhroliveira.wearableandhealth.dto.ContatoUsuarioDTO;
import com.luanhroliveira.wearableandhealth.dto.EnderecoUsuarioDTO;
import com.luanhroliveira.wearableandhealth.dto.UsuarioDTO;
import com.luanhroliveira.wearableandhealth.entitites.ContatoUsuario;
import com.luanhroliveira.wearableandhealth.entitites.EnderecoUsuario;
import com.luanhroliveira.wearableandhealth.entitites.Usuario;
import com.luanhroliveira.wearableandhealth.entitites.enums.Status;
import com.luanhroliveira.wearableandhealth.repositories.ContatoUsuarioRepository;
import com.luanhroliveira.wearableandhealth.repositories.EnderecoUsuarioRepository;
import com.luanhroliveira.wearableandhealth.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ContatoUsuarioRepository contatoRepository;
	@Autowired
	private EnderecoUsuarioRepository enderecoRepositpry;

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

	@Transactional
	public UsuarioDTO insert(UsuarioDTO dto) {

		if (dto.getContatos().size() == 0) {
			throw new AuthorizationServiceException("Necessário ao mínimo 1(um) contato para o usuário!");
		} else if (dto.getEnderecos().size() == 0) {
			throw new AuthorizationServiceException("Necessário ao mínimo 1(um) endereço para o usuário!");
		} else if (dto.getDataNascimento().after(new Date())) {
			throw new AuthorizationServiceException("Data de nascimento não pode ser maior que a data atual!");
		}

		Usuario usuario = new Usuario(null, dto.getNome(), dto.getDataNascimento(), dto.getCpf(), Status.ATIVO);

		for (ContatoUsuarioDTO p : dto.getContatos()) {
			ContatoUsuario contato = new ContatoUsuario(null, usuario, p.getNome(), p.getTelefone(), p.getEmail(),
					Status.ATIVO);
			usuario.getContatos().add(contato);
		}

		for (EnderecoUsuarioDTO p : dto.getEnderecos()) {
			EnderecoUsuario endereco = new EnderecoUsuario(null, usuario, p.getCidade(), p.getLogradouro(),
					p.getNumero(), p.getComplemento(), p.getBairro(), p.getCep());
			usuario.getEnderecos().add(endereco);
		}

		usuario = usuarioRepository.save(usuario);
		contatoRepository.saveAll(usuario.getContatos());
		enderecoRepositpry.saveAll(usuario.getEnderecos());

		return new UsuarioDTO(usuario);
	}

}
