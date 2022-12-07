package ru.nechunaev.service;

import ru.nechunaev.entity.Measurement;

import java.util.List;

public interface MeasurementService {

    Measurement save(Measurement measurement);

    Measurement findById(Long id);

    List<Measurement> findAll();

    int findRainyDaysCount();
}
