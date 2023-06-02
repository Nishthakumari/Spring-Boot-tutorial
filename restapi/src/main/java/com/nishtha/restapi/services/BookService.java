package com.nishtha.restapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
        try {
            book = list.stream().filter(e -> e.getId() == id).findFirst().get();
        } catch (Exception e) {
            // TODO: handle exception
        }

        return book;
    }

    public Book addBook(Book b) {
        list.add(b);
        return b;
    }

    public void deleteBook(int bid) {
        list = list.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());

    }

    public void updateBook(Book book, int bookId) {
        list = list.stream().map(b -> {
            if (b.getId() == bookId) {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());

            }
            return b;
        }).collect(Collectors.toList());
    }

}
