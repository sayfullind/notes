package ru.macloud.rest_api.exceptions;

public class NoteNotFoundException extends RuntimeException {

    private final static String STANDART_MESSAGE = "Note with id %d not found.";

    public NoteNotFoundException(Long id) {
        super(String.format(STANDART_MESSAGE, id));
    }

    public NoteNotFoundException(String message) {
        super(message);
    }
}
