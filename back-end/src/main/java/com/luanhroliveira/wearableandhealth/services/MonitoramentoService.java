package com.luanhroliveira.wearableandhealth.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luanhroliveira.wearableandhealth.dto.MonitoramentoDTO;
import com.luanhroliveira.wearableandhealth.entitites.Monitoramento;
import com.luanhroliveira.wearableandhealth.repositories.MonitoramentoRepository;

@Service
public class MonitoramentoService {

	@Autowired
	private MonitoramentoRepository monitoramentoRepository;

	@Transactional(readOnly = true)
	public List<MonitoramentoDTO> findAll() {
		List<Monitoramento> listMonitoramento = monitoramentoRepository.findAll();
		return listMonitoramento.stream().map(x -> new MonitoramentoDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public Optional<MonitoramentoDTO> findById(Long id) {
		Optional<Monitoramento> monitoramento = monitoramentoRepository.findById(id);
		return Optional.ofNullable(monitoramento.map(x -> new MonitoramentoDTO(x)).get());
	}
}
