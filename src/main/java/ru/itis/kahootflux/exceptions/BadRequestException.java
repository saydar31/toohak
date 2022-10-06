package ru.itis.kahootflux.exceptions;


public class BadRequestException extends RuntimeException {
    public BadRequestException(String template, Object... args) {
        super(String.format(template, args));
    }
}
