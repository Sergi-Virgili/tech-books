package com.vir.repositories;

import com.vir.models.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();

    void save(Book book);


}
