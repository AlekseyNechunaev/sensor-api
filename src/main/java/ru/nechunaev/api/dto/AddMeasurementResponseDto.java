package ru.nechunaev.api.dto;

import java.util.Date;

public class AddMeasurementResponseDto {

    private Long measurementsId;
    private Date createdAt;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getMeasurementsId() {
        return measurementsId;
    }

    public void setMeasurementsId(Long measurementsId) {
        this.measurementsId = measurementsId;
    }
}
