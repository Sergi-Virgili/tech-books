package com.vir;

import com.vir.models.Book;
import com.vir.repositories.BookRepository;
import com.vir.repositories.in_memory.InMemoryBookRepository;
import com.vir.services.BookService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        BookRepository repository = new InMemoryBookRepository();

        List<Book> bookList = new BookService(repository).getBooks();

        for (Book book : bookList) {
            System.out.println(book.getTitle());
        }
    }
}