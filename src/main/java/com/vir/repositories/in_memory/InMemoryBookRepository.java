package com.vir.repositories.in_memory;

import com.vir.models.Book;
import com.vir.repositories.BookRepository;

import java.util.List;

public class InMemoryBookRepository implements BookRepository {

    @Override
    public List<Book> findAll() {
        return InMemoryDatabase.books;
    }

    @Override
    public void save(Book book) {
        InMemoryDatabase.books.add(book);
    }
}
