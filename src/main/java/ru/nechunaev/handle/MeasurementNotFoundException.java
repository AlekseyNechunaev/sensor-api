package ru.nechunaev.handle;

public class MeasurementNotFoundException extends RuntimeException {

    public MeasurementNotFoundException(String message) {
        super(message);
    }
}
