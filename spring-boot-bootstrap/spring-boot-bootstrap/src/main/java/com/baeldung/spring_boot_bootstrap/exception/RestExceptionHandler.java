package com.baeldung.spring_boot_bootstrap.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Uygulamadaki global exception handler.
 * API çağrılarında oluşabilecek istisnaları tek bir noktadan yönetir.
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Kitap bulunamadığında 404 döner.
     */
    @ExceptionHandler({ BookNotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(Exception ex, WebRequest request) {
        return handleExceptionInternal(
                ex,
                "Book not found",
                new HttpHeaders(),
                HttpStatus.NOT_FOUND,
                request
        );
    }

    /**
     * Book ID uyuşmazlığı, validation hataları ve veri bütünlüğü hatalarında 400 döner.
     */
    @ExceptionHandler({ BookIdMismatchException.class,
            ConstraintViolationException.class,
            DataIntegrityViolationException.class })
    public ResponseEntity<Object> handleBadRequest(Exception ex, WebRequest request) {
        return handleExceptionInternal(
                ex,
                ex.getLocalizedMessage(),
                new HttpHeaders(),
                HttpStatus.BAD_REQUEST,
                request
        );
    }
}
