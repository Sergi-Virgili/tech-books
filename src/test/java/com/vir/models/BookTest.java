package com.vir.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BookTest {

    @Test
    void whenBookIsCreated_thenTitleIsSet() {
        Book book = new Book("The Hobbit");
        assertEquals("The Hobbit", book.getTitle());
    }
}