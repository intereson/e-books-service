package by.intereson.ebooksservice.repositories;

import by.intereson.ebooksservice.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> readBooks();

    Book createBook(Book book);
    Optional<Book> readBook(long id);

    boolean deleteBook(Book book);

    Book updateBook(Book book, Book bookNew);
}
