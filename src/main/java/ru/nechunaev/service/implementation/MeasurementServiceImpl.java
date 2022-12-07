package ru.nechunaev.service.implementation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nechunaev.entity.Measurement;
import ru.nechunaev.service.MeasurementService;

import java.util.List;

@Service
@Transactional
public class MeasurementServiceImpl implements MeasurementService {
    @Override
    public Measurement save(Measurement measurement) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Measurement findById(Long id) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Measurement> findAll() {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public int findRainyDaysCount() {
        return 0;
    }
}
