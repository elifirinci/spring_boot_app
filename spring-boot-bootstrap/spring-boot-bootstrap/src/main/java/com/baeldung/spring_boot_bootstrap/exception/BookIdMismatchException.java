package com.baeldung.spring_boot_bootstrap.exception;

/**
 * Kitap güncelleme işlemlerinde URL'deki ID ile
 * body'deki ID uyuşmadığında fırlatılır.
 */
public class BookIdMismatchException extends RuntimeException {

    public BookIdMismatchException() {
        super("Book ID in the path does not match the ID in the request body.");
    }

    public BookIdMismatchException(String message) {
        super(message);
    }

    public BookIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
