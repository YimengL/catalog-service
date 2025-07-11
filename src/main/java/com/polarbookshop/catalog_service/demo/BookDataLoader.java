package com.polarbookshop.catalog_service.demo;


import com.polarbookshop.catalog_service.domain.Book;
import com.polarbookshop.catalog_service.domain.BookRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("testdata") // Assigns the class to the testdata profile. It will be registered only when the testdata profile is active
public class BookDataLoader {
    private final BookRepository bookRepository;


    public BookDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * The test data generation is triggered when an {@link ApplicationReadyEvent} is sent - that is when the
     * application startup phase is completed.
     */
    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        bookRepository.deleteAll();
        var book1 = Book.of("1234567891", "Northern Lights", "Lyra Silverstar", 9.90, "Polarsophia");
        var book2 = Book.of("1234567892", "Polar Journey", "Iorek Polarson", 12.90, "Polarsophia");
        bookRepository.saveAll(List.of(book1, book2));
    }
}
