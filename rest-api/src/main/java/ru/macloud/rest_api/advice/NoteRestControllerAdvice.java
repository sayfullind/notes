package ru.macloud.rest_api.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.macloud.rest_api.dto.ErrorMessage;
import ru.macloud.rest_api.exceptions.NoteNotFoundException;

@RestControllerAdvice
public class NoteRestControllerAdvice {
    @ExceptionHandler(NoteNotFoundException.class)
    public ResponseEntity<ErrorMessage> noteNotFoundException(NoteNotFoundException ex) {
        final var errorMessage =
                ErrorMessage.builder().description(ex.getMessage()).build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
