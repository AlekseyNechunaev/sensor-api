package ru.nechunaev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nechunaev.entity.Sensor;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {

    boolean existsByName(String name);
}
