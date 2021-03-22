package com.luanhroliveira.wearableandhealth.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.luanhroliveira.wearableandhealth.controllers.exceptions.FieldMessage;
import com.luanhroliveira.wearableandhealth.dto.ContatoUsuarioNewDTO;
import com.luanhroliveira.wearableandhealth.entitites.ContatoUsuario;
import com.luanhroliveira.wearableandhealth.repositories.ContatoUsuarioRepository;

public class ContatoInsertValidator implements ConstraintValidator<ContatoInsert, ContatoUsuarioNewDTO> {

	@Autowired
	private ContatoUsuarioRepository contatoRepository;

	@Override
	public void initialize(ContatoInsert ann) {
	}

	@Override
	public boolean isValid(ContatoUsuarioNewDTO objDto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();

		ContatoUsuario contato = contatoRepository.findByEmail(objDto.getEmail());

		if (contato != null) {
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
