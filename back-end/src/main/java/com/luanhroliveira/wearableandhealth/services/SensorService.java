package com.luanhroliveira.wearableandhealth.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luanhroliveira.wearableandhealth.dto.SensorDTO;
import com.luanhroliveira.wearableandhealth.entitites.Sensor;
import com.luanhroliveira.wearableandhealth.repositories.SensorRepository;
import com.luanhroliveira.wearableandhealth.services.exceptions.DataIntegrityException;
import com.luanhroliveira.wearableandhealth.services.exceptions.ResourceNotFoundException;

@Service
public class SensorService {

	@Autowired
	private SensorRepository sensorRepository;
	/*
	 * @Autowired private UsuarioRepository usuarioRepository;
	 */

	@Transactional(readOnly = true)
	public List<SensorDTO> findAll() {
		List<Sensor> sensor = sensorRepository.findAll();
		return sensor.stream().map(x -> new SensorDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public Optional<SensorDTO> findById(Long id) {
		Optional<Sensor> sensor = sensorRepository.findById(id);
		return Optional
				.ofNullable(sensor.map(x -> new SensorDTO(x)).orElseThrow(() -> new ResourceNotFoundException(id)));
	}

	/*
	 * @Transactional public Page<Sensor> search(String nome, List<Integer> ids,
	 * Integer page, Integer linesPerPage, Sort.Direction direction, String orderBy)
	 * { try { PageRequest pageRequest = PageRequest.of(page, linesPerPage,
	 * direction, orderBy); List<Usuario> usuarios =
	 * usuarioRepository.findAllById(ids);
	 * 
	 * return sensorRepository.search(nome, usuarios, pageRequest); } catch
	 * (RuntimeException e) { throw new RuntimeException(e.getMessage()); }
	 * 
	 * }
	 */

	@Transactional
	public SensorDTO insert(SensorDTO dto) {
		Sensor sensor = new Sensor(null, dto.getNome());
		sensorRepository.save(sensor);
		return new SensorDTO(sensor);
	}

	public SensorDTO update(Long id, SensorDTO dto) {
		try {
			Sensor sensor = sensorRepository.getOne(id);
			update(sensor, dto);
			sensor = sensorRepository.save(sensor);
			return new SensorDTO(sensor);
		} catch (DataIntegrityException e) {
			throw new DataIntegrityException(e.getMessage());
		}
	}

	private void update(Sensor sensor, SensorDTO dto) {
		sensor.setNome(dto.getNome());
	}

	public void delete(Long id) {
		try {
			sensorRepository.deleteById(id);
		} catch (DataIntegrityException e) {
			throw new DataIntegrityException(e.getMessage());
		}
	}
}
