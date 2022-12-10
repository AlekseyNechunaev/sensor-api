package ru.nechunaev.api.dto;

import java.time.LocalDateTime;

public class ErrorResponseDto {

    private final int status;

    private final LocalDateTime date;

    private final String description;

    public ErrorResponseDto(int status, LocalDateTime date, String description) {
        this.status = status;
        this.date = date;
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}
