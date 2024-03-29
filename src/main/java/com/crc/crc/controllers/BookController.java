package com.crc.crc.controllers;

import com.crc.crc.entities.Book;
import com.crc.crc.services.BookService;
import com.mongodb.client.AggregateIterable;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/book")
    public Book addBook(@RequestBody Book book) {
        return bookService.insertBook(book);
    }

    @GetMapping("/book/test")
    public List<Document> getTestBooks() {
        return bookService.test();
    }

}
