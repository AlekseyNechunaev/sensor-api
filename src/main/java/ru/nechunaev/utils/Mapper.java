package ru.nechunaev.utils;

import org.springframework.stereotype.Component;
import ru.nechunaev.api.dto.*;
import ru.nechunaev.entity.Measurement;
import ru.nechunaev.entity.Sensor;

@Component
public class Mapper {

    public Sensor mapToEntity(RegSensorRequestDto regSensorRequestDto) {
        Sensor sensor = new Sensor();
        sensor.setName(regSensorRequestDto.getName());
        return sensor;
    }

    public RegSensorResponseDto mapToDto(Sensor sensor) {
        RegSensorResponseDto regSensorResponseDto = new RegSensorResponseDto();
        regSensorResponseDto.setSensorId(sensor.getId());
        return regSensorResponseDto;
    }

    public Measurement mapToEntity(AddMeasurementRequestDto addMeasurementRequestDto) {
        Measurement measurement = new Measurement();
        measurement.setValue(addMeasurementRequestDto.getValue());
        measurement.setRaining(addMeasurementRequestDto.isRaining());
        measurement.setSensor(mapToEntity(addMeasurementRequestDto.getSensor()));
        return measurement;
    }

    public AddMeasurementResponseDto mapToDto(Measurement measurement) {
        AddMeasurementResponseDto addMeasurementResponseDto = new AddMeasurementResponseDto();
        addMeasurementResponseDto.setMeasurementsId(measurement.getId());
        addMeasurementResponseDto.setCreatedAt(measurement.getCreatedAt());
        return addMeasurementResponseDto;
    }

    public RainyDaysCountDto mapToDto(int isRainingDaysCount) {
        RainyDaysCountDto rainyDaysCountDto = new RainyDaysCountDto();
        rainyDaysCountDto.setDaysCount(isRainingDaysCount);
        return rainyDaysCountDto;
    }
}
