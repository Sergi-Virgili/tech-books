package com.vir.repositories.in_memory;

import com.vir.models.Book;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabase {

    public static List<Book> books = new ArrayList<>(
        List.of(
            new Book("The Great Gatsby"),
            new Book("To Kill a Mockingbird"),
            new Book("1984"),
            new Book("Pride and Prejudice"),
            new Book("The Catcher in the Rye")
    ));
}
