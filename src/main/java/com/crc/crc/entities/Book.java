package com.crc.crc.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Book {
    @Id
    private String id;
    private String name;
    private List<String> authors;
    private Integer releaseYear;
    private Double price;
}
