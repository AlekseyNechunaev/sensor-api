package ru.nechunaev.handle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.nechunaev.api.dto.ErrorResponseDto;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class HandleController {

    @ExceptionHandler(value = SensorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDto sensorNotFoundException(SensorNotFoundException ex) {
        return new ErrorResponseDto(HttpStatus.NOT_FOUND.value(), LocalDateTime.now(), ex.getMessage());
    }

    @ExceptionHandler(value = MeasurementNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDto measurementNotFoundException(MeasurementNotFoundException ex) {
        return new ErrorResponseDto(HttpStatus.NOT_FOUND.value(), LocalDateTime.now(), ex.getMessage());
    }

    @ExceptionHandler(value = SensorExistsNameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDto sensorExistsNameException(SensorExistsNameException ex) {
        return new ErrorResponseDto(HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(), ex.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDto notValidException(MethodArgumentNotValidException ex) {
        String errors = ex.getFieldErrors().stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return new ErrorResponseDto(HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(), errors);
    }
}
