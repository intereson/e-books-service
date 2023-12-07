package by.intereson.ebooksservice.services;

import by.intereson.ebooksservice.entities.Book;
import by.intereson.ebooksservice.repositories.BookRepository;
import by.intereson.ebooksservice.repositories.BookRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {
    private BookServiceImpl() {
    }

    private static BookService bookService;
    private final BookRepository bookRepository = BookRepositoryImpl.getInstance();

    public static BookService getInstance() {
        if (bookService == null) {
            bookService = new BookServiceImpl();
        }
        return bookService;
    }

    @Override
    public List<Book> readBooks() {
        return bookRepository.readBooks();
    }

    @Override
    public Book createBook(Book book) {
        bookRepository.createBook(book);
        return book;
    }

    @Override
    public Book readBook(long id) {
        return bookRepository.readBook(id).orElseGet(null);

    }

    @Override
    public boolean deleteBook(Book book) {
        return bookRepository.deleteBook(book);
    }

    @Override
    public Book updateBook(Book book, Book bookNew) {
        return bookRepository.updateBook(book,bookNew);
    }
}
