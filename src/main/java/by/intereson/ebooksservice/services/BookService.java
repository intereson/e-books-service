package by.intereson.ebooksservice.services;

import by.intereson.ebooksservice.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {


    List<Book> readBooks();

    Book createBook(Book book);
    Book readBook(long id);

    boolean deleteBook(Book book);

    Book updateBook(Book book, Book bookNew);
}
