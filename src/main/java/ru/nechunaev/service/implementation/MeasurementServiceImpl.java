package ru.nechunaev.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nechunaev.entity.Measurement;
import ru.nechunaev.entity.Sensor;
import ru.nechunaev.handle.MeasurementNotFoundException;
import ru.nechunaev.handle.SensorNotFoundException;
import ru.nechunaev.repository.MeasurementRepository;
import ru.nechunaev.repository.SensorRepository;
import ru.nechunaev.service.MeasurementService;

import java.util.List;

@Service
@Transactional
public class MeasurementServiceImpl implements MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final SensorRepository sensorRepository;

    @Autowired
    public MeasurementServiceImpl(MeasurementRepository measurementRepository, SensorRepository sensorRepository) {
        this.measurementRepository = measurementRepository;
        this.sensorRepository = sensorRepository;
    }

    @Override
    public Measurement save(Measurement measurement) {
        String sensorName = measurement.getSensor().getName();
        if (!sensorRepository.existsByName(sensorName)) {
            throw new SensorNotFoundException();
        }
        Sensor sensor = sensorRepository.findByName(sensorName);
        measurement.setSensor(sensor);
        measurementRepository.save(measurement);
        return measurement;
    }

    @Override
    @Transactional(readOnly = true)
    public Measurement findById(Long id) {
        return measurementRepository.findById(id).orElseThrow(MeasurementNotFoundException::new);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Measurement> findAll() {
        return measurementRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public int findIsRainingDaysCount(boolean isRaining) {
        return measurementRepository.countALlByIsRainingIs(isRaining);
    }
}
