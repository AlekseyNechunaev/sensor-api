package ru.nechunaev.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class AddMeasurementRequestDto {

    @NotNull
    @Min(-100)
    @Max(100)
    private float value;

    @JsonProperty("raining")
    @NotNull
    private boolean isRaining;

    @NotNull
    private RegSensorRequestDto sensor;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public boolean isRaining() {
        return isRaining;
    }

    public void setRaining(boolean raining) {
        isRaining = raining;
    }

    public RegSensorRequestDto getSensor() {
        return sensor;
    }

    public void setSensor(RegSensorRequestDto sensor) {
        this.sensor = sensor;
    }
}
