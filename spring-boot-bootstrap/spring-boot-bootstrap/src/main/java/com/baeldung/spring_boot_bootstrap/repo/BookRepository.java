package com.baeldung.spring_boot_bootstrap.repo;

import com.baeldung.spring_boot_bootstrap.model.Book;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Book entity'si için CRUD ve özel sorguları tanımlar.
 */
public interface BookRepository extends CrudRepository<Book, Long> {

    // Başlığa göre kitap araması yapar
    List<Book> findByTitle(String title);
}
