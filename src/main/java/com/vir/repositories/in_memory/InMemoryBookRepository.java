package com.vir.repositories.in_memory;

import com.vir.models.Book;
import com.vir.repositories.BookRepository;
import jdk.jshell.spi.ExecutionControl;

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

    @Override
    public void update(String oldTitle, String newTitle) {
        throw new UnsupportedOperationException("not implemented method");
    }

    @Override
    public void delete(String title) {
        throw new UnsupportedOperationException("not implemented method");
    }

}
