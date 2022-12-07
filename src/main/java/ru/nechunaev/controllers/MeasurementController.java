package ru.nechunaev.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nechunaev.api.dto.AddMeasurementRequestDto;
import ru.nechunaev.api.dto.AddMeasurementResponseDto;
import ru.nechunaev.api.dto.RainyDaysCountDto;
import ru.nechunaev.constants.Paths;
import ru.nechunaev.entity.Measurement;
import ru.nechunaev.service.MeasurementService;
import ru.nechunaev.utils.Mapper;

import java.util.List;

@RequestMapping(Paths.Measurements.MEASUREMENT)
@RestController
public class MeasurementController {

    private final MeasurementService measurementService;
    private final Mapper mapper;

    @Autowired
    public MeasurementController(MeasurementService measurementService, Mapper mapper) {
        this.measurementService = measurementService;
        this.mapper = mapper;
    }

    @PostMapping
    public AddMeasurementResponseDto registration(@RequestBody @Valid AddMeasurementRequestDto addMeasurementRequestDto) {
        Measurement measurement = mapper.mapToEntity(addMeasurementRequestDto);
        return mapper.mapToDto(measurementService.save(measurement));
    }

    @GetMapping
    public ResponseEntity<List<Measurement>> getAll() {
        return new ResponseEntity<>(measurementService.findAll(), HttpStatus.OK);
    }

    @GetMapping(Paths.Measurements.GET_ONE)
    public ResponseEntity<Measurement> getById(@PathVariable Long id) {
        return new ResponseEntity<>(measurementService.findById(id), HttpStatus.OK);
    }

    @GetMapping(Paths.Measurements.RAINY)
    public RainyDaysCountDto getDaysCountIsRaining(@RequestParam("is_raining") boolean isRaining) {
        return mapper.mapToDto(measurementService.findIsRainingDaysCount(isRaining));
    }
}
