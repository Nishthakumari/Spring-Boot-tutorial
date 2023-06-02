package com.nishtha.restapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nishtha.restapi.entities.Book;

@Component
public class BookService {

    private static List<Book> list = new ArrayList<Book>();

    static {
        list.add(new Book(12, "Java Complete Reference", "XUD"));
        list.add(new Book(36, "Head first to Java ", "QWE"));
        list.add(new Book(12963, "THink in Java ", "AABC"));

    }

    public List<Book> getAllBooks() {
        return list;
    }

    public Book getBookById(int id) {
        Book book = null;
        book = list.stream().filter(e -> e.getId() == id).findFirst().get();
        return book;
    }
}
