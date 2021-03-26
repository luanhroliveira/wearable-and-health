package com.luanhroliveira.wearableandhealth.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luanhroliveira.wearableandhealth.dto.MonitoramentoDTO;
import com.luanhroliveira.wearableandhealth.dto.MonitoramentoNewDTO;
import com.luanhroliveira.wearableandhealth.entitites.Monitoramento;
import com.luanhroliveira.wearableandhealth.services.MonitoramentoService;

@RestController
@RequestMapping(value = "/monitoramentos")
public class MonitoramentoController {

	@Autowired
	public MonitoramentoService monitoramentoService;

	@GetMapping
	public ResponseEntity<List<MonitoramentoDTO>> findAll() {
		List<MonitoramentoDTO> listMonitoramento = monitoramentoService.findAll();
		return ResponseEntity.ok().body(listMonitoramento);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<MonitoramentoDTO>> findById(@PathVariable Long id) {
		Optional<MonitoramentoDTO> monitoramento = monitoramentoService.findById(id);
		return ResponseEntity.ok().body(monitoramento);
	}

	@GetMapping(value = "/page")
	public ResponseEntity<Page<MonitoramentoDTO>> findBySensorAndUsuario(
			@RequestParam(value = "sensor", defaultValue = "") Long sensor,
			@RequestParam(value = "usuario", defaultValue = "") Long usuario,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "usuario") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") Sort.Direction direction) {
		/*
		 * String nomeDecode = URL.decodeParam(nome);
		 * 
		 * List<Integer> idUsuarios = Arrays.asList(usuarios.split(",")).stream().map(x
		 * -> Integer.parseInt(x)) .collect(Collectors.toList());
		 */
		/*
		 * age<Monitoramento> monitoramentos = monitoramentoService.search(nomeDecode,
		 * ids, page, linesPerPage, direction, orderBy);
		 */
		Page<Monitoramento> monitoramentos = monitoramentoService.findBySensorAndUsuario(sensor, usuario, page,
				linesPerPage, direction, orderBy);
		return ResponseEntity.ok().body(monitoramentos.map(x -> new MonitoramentoDTO(x)));
	}

	@PostMapping
	public ResponseEntity<MonitoramentoNewDTO> insert(@RequestBody MonitoramentoNewDTO dto) {
		dto = monitoramentoService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
}
