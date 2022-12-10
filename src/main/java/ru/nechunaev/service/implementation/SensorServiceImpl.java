package ru.nechunaev.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nechunaev.entity.Sensor;
import ru.nechunaev.handle.SensorExistsNameException;
import ru.nechunaev.handle.SensorNotFoundException;
import ru.nechunaev.repository.SensorRepository;
import ru.nechunaev.service.SensorService;

import java.util.List;

@Service
@Transactional
public class SensorServiceImpl implements SensorService {

    private final SensorRepository sensorRepository;

    @Autowired
    public SensorServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public Sensor save(Sensor sensor) {
        if (isExistsByName(sensor.getName())) {
            throw new SensorExistsNameException("a sensor with the same name = " + sensor.getName() + " is already registered");
        }
        sensorRepository.save(sensor);
        return sensor;
    }

    @Override
    @Transactional(readOnly = true)
    public Sensor findById(Long id) {
        return sensorRepository.findById(id).orElseThrow(() ->
                new SensorNotFoundException("sensor with this id = " + id + " not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isExistsByName(String name) {
        return sensorRepository.existsByName(name);
    }
}
