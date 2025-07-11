package com.polarbookshop.catalog_service.domain;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

// Extends a repository providing CRUD operations, specifying the type of managed entity (Book) and its primary key type (Long).
public interface BookRepository extends CrudRepository<Book, Long> {

    // Methods implemented by Spring Data at runtime
    Optional<Book> findByIsbn(String isbn);
    boolean existsByIsbn(String isbn);

    @Modifying // Identifies an operation that will modify the database state
    @Transactional // Identifies the method to be executed in a transaction
    @Query("delete from Book where isbn = :isbn") // Declares the query that Spring Data will use to implement the method
    void deleteByIsbn(String isbn);
}
