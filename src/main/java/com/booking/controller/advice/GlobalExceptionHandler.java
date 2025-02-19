package com.booking.controller.advice;

import com.booking.openapi.model.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.TimestampMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.booking.exception.BadRequestException;
import com.booking.exception.HotelNotFoundException;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * * Handling HotelNotFoundException
     */
    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<ErrorDto> handleHotelNotFoundException(HotelNotFoundException ex) {
        log.error("HotelNotFoundException caught: {}", ex.getMessage(), ex);

        ErrorDto apiError = createErrorDto(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    /**
     * * Handling BadRequestException
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDto> handleBadRequestException(BadRequestException ex) {
        log.warn("BadRequestException caught: {}", ex.getMessage(), ex);

        ErrorDto apiError = createErrorDto(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }

    /**
     * Handling a common RuntimeException
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDto> handleRuntimeException(RuntimeException ex) {
        log.error("RuntimeException caught: {}", ex.getMessage(), ex);

        ErrorDto apiError = createErrorDto(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
    }

    /**
     * Auxiliary method for creating an ErrorDto object
     */
    private ErrorDto createErrorDto(HttpStatus status, String message) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setErrorCode(status.value());
        errorDto.setErrorMessage(message);
        errorDto.setTimestamp(LocalDateTime.now());

        return errorDto;
    }
}
