package com.vir.repositories;

import com.vir.models.Book;

import java.util.List;

public interface BookRepository {
    void save(Book book);

    List<Book> findAll();

    void update(String oldTitle, String newTitle);

    void delete(String title);
}
