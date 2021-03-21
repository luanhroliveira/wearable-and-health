package com.luanhroliveira.wearableandhealth.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.luanhroliveira.wearableandhealth.dto.MonitoramentoDTO;
import com.luanhroliveira.wearableandhealth.dto.MonitoramentoNewDTO;
import com.luanhroliveira.wearableandhealth.entitites.Monitoramento;
import com.luanhroliveira.wearableandhealth.repositories.MonitoramentoRepository;
import com.luanhroliveira.wearableandhealth.services.exceptions.DataIntegrityException;

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

	@Transactional
	public MonitoramentoNewDTO insert(@RequestBody MonitoramentoNewDTO dto) {
		try {
			Monitoramento monitoramento = new Monitoramento(null, dto.getUsuario(), dto.getSensor(),
					dto.getValorSensorDouble(), dto.getValorSensorString(), dto.getValorSensorBoolean());
			monitoramentoRepository.save(monitoramento);
			return new MonitoramentoNewDTO(monitoramento);
		} catch (DataIntegrityException e) {
			throw new DataIntegrityException(e.getMessage());
		}
	}
}
