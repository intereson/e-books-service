package by.intereson.ebooksservice.services;

import by.intereson.ebooksservice.entities.Book;
import by.intereson.ebooksservice.repositories.BookRepository;
import by.intereson.ebooksservice.repositories.BookRepositoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static by.intereson.ebooksservice.utils.Constants.*;

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
        return bookRepository.readBook(id).orElse(new Book(9999, "no data", "no data", 9999, "no data", "no data", 0, LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_FORMAT))));
    }
    public List<Book> getBook(long id){
        List<Book> book=new ArrayList<>();
        book.add(readBook(id));
        return book;
    }


    @Override
    public boolean deleteBook(Book book) {
        return bookRepository.deleteBook(book);
    }

    @Override
    public Book updateBook(Book book, Book bookNew) {
        return bookRepository.updateBook(book, bookNew);
    }

    @Override
    public boolean checkBookData(HttpServletRequest req) {
        return (!req.getParameter(BOOK_NAME).isEmpty())
                && (!req.getParameter(AUTHOR).isEmpty())
                && (!req.getParameter(YEAR_OF_PUBLISHING).isEmpty())
                && (!req.getParameter(PUBLISHING_HOUSE).isEmpty())
                && (!req.getParameter(ANNOTATION).isEmpty())
                && (!req.getParameter(PRICE_INT).isEmpty())
                && (!req.getParameter(PRICE_FRAC).isEmpty());
    }

    @Override
    public Double getPrice(HttpServletRequest request) {
        double price_int = Double.parseDouble(request.getParameter(PRICE_INT));
        double price_frac = Double.parseDouble(request.getParameter(PRICE_FRAC));
        return price_int + price_frac / 100;
    }
}
