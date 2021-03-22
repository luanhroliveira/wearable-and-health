package com.luanhroliveira.wearableandhealth.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.luanhroliveira.wearableandhealth.controllers.exceptions.FieldMessage;
import com.luanhroliveira.wearableandhealth.dto.ContatoUsuarioDTO;
import com.luanhroliveira.wearableandhealth.entitites.ContatoUsuario;
import com.luanhroliveira.wearableandhealth.repositories.ContatoUsuarioRepository;

public class ContatoUpdateValidator implements ConstraintValidator<ContatoUpdate, ContatoUsuarioDTO> {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private ContatoUsuarioRepository contatoRepository;

	@Override
	public void initialize(ContatoUpdate ann) {
	}

	@Override
	public boolean isValid(ContatoUsuarioDTO objDto, ConstraintValidatorContext context) {
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request
				.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

		Integer uriId = Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();

		ContatoUsuario contato = contatoRepository.findByEmail(objDto.getEmail());

		if (contato != null && !contato.getId().equals(uriId)) {
			list.add(new FieldMessage("email", "Email já existente!"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
