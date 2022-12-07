package ru.nechunaev.utils;

import org.springframework.stereotype.Component;
import ru.nechunaev.api.dto.RegSensorRequestDto;
import ru.nechunaev.api.dto.RegSensorResponseDto;
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
}
