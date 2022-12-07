package ru.nechunaev.service;

import ru.nechunaev.entity.Sensor;

import java.util.List;

public interface SensorService {

    Sensor save(Sensor sensor);

    Sensor findById(Long id);

    List<Sensor> findAll();

    boolean isExistsByName(String name);
}
