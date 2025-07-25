package com.polarbookshop.catalog_service.domain;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import java.time.Instant;

// The domain model is implemented as a record, an immutable object.
public record Book(

        @Id
        Long id, // Identifies the field as the primary key for the entity

        @NotBlank(message = "The book ISBN must be defined.")
        @Pattern(
                regexp = "^([0-9]{10}|[0-9]{13})$",
                message = "The ISBN format must be valid."
        )
        String isbn, // Unique identifier for the book

        @NotBlank(message = "The book title must be defined.")
        String title,

        @NotBlank(message = "The book author must be defined.")
        String author,

        @NotNull(message = "The book price must be defined.")
        @Positive(message = "The book price must be greater than zero.")
        Double price,

        String publisher,

        @CreatedDate
        Instant createdDate,

        @LastModifiedDate
        Instant lastModifiedDate,

        @Version
        int version // The entity version number, which is used for optimistic locking
) {
        public static Book of(String isbn, String title, String author, Double price, String publisher) {
                // An entity is considered new when the ID is null and the version is 0
                return new Book(null, isbn, title, author, price, publisher, null, null, 0);
        }
}
