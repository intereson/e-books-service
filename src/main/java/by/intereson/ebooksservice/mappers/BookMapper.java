package by.intereson.ebooksservice.mappers;

import by.intereson.ebooksservice.entities.Book;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static by.intereson.ebooksservice.utils.Constants.*;

public class BookMapper {
    public Book buildBook(HttpServletRequest request) {
        return Book.builder()
                .bookName(request.getParameter(BOOK_NAME))
                .author(request.getParameter(AUTHOR))
                .yearOfPublishing(Integer.parseInt(request.getParameter(YEAR_OF_PUBLISHING)))
                .publishingHouse(request.getParameter(PUBLISHING_HOUSE))
                .annotation(request.getParameter(ANNOTATION))
                .price(Double.parseDouble(request.getParameter(PRICE)))
                .dateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.uuuu HH-mm")))
                .build();
    }
}
