package by.intereson.ebooksservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    private long id;
    private String bookName;
    private String author;
    private int yearOfPublishing;
    private String publishingHouse;
    private String annotation;
    private double price;
}
