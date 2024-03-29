package com.crc.crc.services;

import com.crc.crc.entities.Book;
import com.crc.crc.repository.BookRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MongoCollection<Document> bookCollection;

    public Book insertBook(Book book) {
        log.info("Inserting book to database");
        return bookRepository.insert(book);
    }

    public List<Book> getAllBooks() {
        log.info("Fetching all books from database");
        return bookRepository.findAll();
    }

    public List<Document> test() {
        List<Document> result = new ArrayList<>();
        bookCollection.aggregate(Arrays.asList(
                Aggregates.match(Filters.eq("name", "Nazwa książki2")),
                Aggregates.unwind("$authors"),
                Aggregates.project(Projections.fields(Projections.excludeId(), Projections.include("name")))
        )).forEach(result::add);

        return result;
    }

}
