package by.intereson.ebooksservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Order {
    private long id;
    private List<Book> books;
    private double totalPrice;

}
