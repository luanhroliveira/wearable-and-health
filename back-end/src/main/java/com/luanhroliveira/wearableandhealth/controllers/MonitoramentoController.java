package com.luanhroliveira.wearableandhealth.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luanhroliveira.wearableandhealth.dto.MonitoramentoDTO;
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

}