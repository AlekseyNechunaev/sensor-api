package ru.nechunaev.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class AddMeasurementRequestDto {

    @NotNull
    @Min(-100)
    @Max(100)
    private Float value;

    @JsonProperty("raining")
    @NotNull
    private Boolean isRaining;

    @NotNull
    private RegSensorRequestDto sensor;

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Boolean isRaining() {
        return isRaining;
    }

    public void setRaining(Boolean raining) {
        isRaining = raining;
    }

    public RegSensorRequestDto getSensor() {
        return sensor;
    }

    public void setSensor(RegSensorRequestDto sensor) {
        this.sensor = sensor;
    }
}
