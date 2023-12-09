package by.intereson.ebooksservice.mappers;

import by.intereson.ebooksservice.entities.Book;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static by.intereson.ebooksservice.utils.Constants.*;

public class BookMapper {
    private static final BookMapper bookMapper=getInstance();
    public Book buildBook(HttpServletRequest request) {
        return Book.builder()
                .bookName(request.getParameter(BOOK_NAME))
                .author(request.getParameter(AUTHOR))
                .yearOfPublishing(Integer.parseInt(request.getParameter(YEAR_OF_PUBLISHING)))
                .publishingHouse(request.getParameter(PUBLISHING_HOUSE))
                .annotation(request.getParameter(ANNOTATION))
                .price(Double.parseDouble(request.getParameter(PRICE)))
                .dateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_FORMAT)))
                .build();
    }
    public static BookMapper getInstance(){
        if(bookMapper==null){
            return new BookMapper();
        }
        return bookMapper;
    }
}
