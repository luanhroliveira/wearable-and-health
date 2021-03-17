package com.luanhroliveira.wearableandhealth.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
import com.luanhroliveira.wearableandhealth.services.exceptions.AuthorizationException;
import com.luanhroliveira.wearableandhealth.services.exceptions.ResourceNotFoundException;

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
		return usuario.map(x -> new UsuarioDTO(x)).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	@Transactional
	public UsuarioDTO insert(UsuarioDTO dto) {
		try {

			if (dto.getContatos().size() == 0) {
				throw new AuthorizationException("Necessário ao mínimo 1(um) contato para o usuário!");
			} else if (dto.getEnderecos().size() == 0) {
				throw new AuthorizationException("Necessário ao mínimo 1(um) endereço para o usuário!");
			} else if (dto.getDataNascimento().after(new Date())) {
				throw new AuthorizationException("Data de nascimento não pode ser maior que a data atual!");
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
		} catch (AuthorizationException e) {
			throw new AuthorizationException(e.getMessage());
		}
	}

	public UsuarioDTO update(Long id, UsuarioDTO dto) {
		try {
			if (dto.getDataNascimento().after(new Date())) {
				throw new AuthorizationException("Data de nascimento não pode ser maior que a data atual!");
			}

			Usuario usuario = usuarioRepository.getOne(id);
			updateData(usuario, dto);

			usuario = usuarioRepository.save(usuario);

			return new UsuarioDTO(usuario);
		} catch (AuthorizationException e) {
			throw new AuthorizationException(e.getMessage());
		}

	}

	private void updateData(Usuario usuario, UsuarioDTO dto) {
		usuario.setCpf(dto.getCpf());
		usuario.setDataNascimento(dto.getDataNascimento());
		usuario.setNome(dto.getNome());
		usuario.setStatus(dto.getStatus());

		for (ContatoUsuarioDTO p : dto.getContatos()) {
			ContatoUsuario contato = contatoRepository.getOne(p.getId());

			contato.setEmail(p.getEmail());
			contato.setNome(p.getNome());
			contato.setTelefone(p.getTelefone());
			contato.setStatus(p.getStatus());
			contato = contatoRepository.save(contato);

			usuario.getContatos().add(contato);
		}

		for (EnderecoUsuarioDTO p : dto.getEnderecos()) {
			EnderecoUsuario endereco = enderecoRepositpry.getOne(p.getId());

			endereco.setCep(p.getCep());
			endereco.setLogradouro(p.getLogradouro());
			endereco.setNumero(p.getNumero());
			endereco.setComplemento(p.getComplemento());
			endereco.setBairro(p.getBairro());
			endereco = enderecoRepositpry.save(endereco);

			usuario.getEnderecos().add(endereco);
		}

	}

	public void delete(Long id) {
		try {
			Usuario usuario = usuarioRepository.getOne(id);
			if (usuario.getMonitoramentos().size() == 0) {
				usuarioRepository.deleteById(id);
			} else {
				throw new AuthorizationException();
			}
		} catch (AuthorizationException e) {
			throw new AuthorizationException("Não é possível excluir usuário que possui dados de monitoramento!");
		}

	}

	public Page<Usuario> findPage(Integer page, Integer linesPerPage, Sort.Direction direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, direction, orderBy);
		return usuarioRepository.findAll(pageRequest);
	}
}
