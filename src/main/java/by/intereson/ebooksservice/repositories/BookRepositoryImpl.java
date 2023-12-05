package by.intereson.ebooksservice.repositories;

import by.intereson.ebooksservice.entities.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepositoryImpl implements BookRepository {
    private static BookRepository bookRepository;
    private final List<Book> books = new ArrayList<>();
    //Arrays.asList(new Book(1,"Java полное руководство.Десятое издание.","Герберт Шилдт",2018,"Диалектика","Исчерпывающее описание языка программирования Java",50.2, LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.uuuu HH-mm"))),
    //new Book(2,"Head first Java 2nd Edition","Kathu Sierra, Bert Bates",2012,"ЭКСМО","Мировой компьтерный бестселлер",44.55,LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.uuuu HH-mm"))));


    public static BookRepository getInstance() {
        if (bookRepository == null) {
            bookRepository = new BookRepositoryImpl();
        }
        return bookRepository;
    }

    @Override
    public List<Book> readBooks() {
        return books;
    }

    @Override
    public Book createBook(Book book) {
        book.setId((long) books.size() + 1);
        books.add(book);
        return book;
    }

    @Override
    public Optional<Book> readBook(long id) {
        return books.stream().filter(books1 -> books1.getId() == id).findFirst();
    }

    @Override
    public boolean deleteBook(Book book) {
        return books.remove(book);
    }

    @Override
    public Book updateBook(Book book, Book bookNew) {
        bookNew.setId(book.getId());
        books.remove(book);
        books.add(bookNew);
        return bookNew;
    }
}

