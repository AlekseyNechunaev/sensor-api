package ru.nechunaev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nechunaev.entity.Measurement;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
}
