package com.baeldung.spring_boot_bootstrap.controller;

import com.baeldung.spring_boot_bootstrap.exception.BookIdMismatchException;
import com.baeldung.spring_boot_bootstrap.exception.BookNotFoundException;
import com.baeldung.spring_boot_bootstrap.model.Book;
import com.baeldung.spring_boot_bootstrap.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // Tüm kitapları getir
    @GetMapping
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    // Belirli başlığa sahip kitap(lar)ı getir
    @GetMapping("/title/{bookTitle}")
    public List<Book> findByTitle(@PathVariable String bookTitle) {
        return bookRepository.findByTitle(bookTitle);
    }

    // ID ile kitap getir
    @GetMapping("/{id}")
    public Book findOne(@PathVariable Long id) {
        return bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
    }

    // Yeni kitap oluştur
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // Kitap sil
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        bookRepository.deleteById(id);
    }

    // Kitap güncelle
    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
        if (!book.getId().equals(id)) {
            throw new BookIdMismatchException();
        }

        bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);

        return bookRepository.save(book);
    }
}
