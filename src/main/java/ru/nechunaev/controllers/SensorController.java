package ru.nechunaev.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nechunaev.api.dto.RegSensorRequestDto;
import ru.nechunaev.api.dto.RegSensorResponseDto;
import ru.nechunaev.constants.Paths;
import ru.nechunaev.entity.Sensor;
import ru.nechunaev.service.SensorService;
import ru.nechunaev.utils.Mapper;

import java.util.List;

@RestController
@RequestMapping(Paths.Sensors.SENSOR)
public class SensorController {

    private final SensorService sensorService;
    private final Mapper mapper;

    @Autowired
    public SensorController(SensorService sensorService, Mapper mapper) {
        this.sensorService = sensorService;
        this.mapper = mapper;
    }

    @PostMapping
    public RegSensorResponseDto registration(@RequestBody @Valid RegSensorRequestDto regSensorRequestDto) {
        Sensor sensor = sensorService.save(mapper.mapToEntity(regSensorRequestDto));
        return mapper.mapToDto(sensor);
    }

    @GetMapping
    public ResponseEntity<List<Sensor>> getAll() {
        return new ResponseEntity<>(sensorService.findAll(), HttpStatus.OK);
    }

    @GetMapping(Paths.Sensors.GET_ONE)
    public ResponseEntity<Sensor> getById(@PathVariable Long id) {
        return new ResponseEntity<>(sensorService.findById(id), HttpStatus.OK);
    }
}
