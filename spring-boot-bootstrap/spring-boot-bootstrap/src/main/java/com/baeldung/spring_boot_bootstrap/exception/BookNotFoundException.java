package com.baeldung.spring_boot_bootstrap.exception;

/**
 * Verilen ID veya başlıkla kitap bulunamadığında fırlatılan özel exception.
 */
public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException() {
        super("Book not found.");
    }

    public BookNotFoundException(String message) {
        super(message);
    }

    public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
