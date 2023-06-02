package com.nishtha.restapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.dialect.MySQLDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nishtha.restapi.dao.BookRepository;
import com.nishtha.restapi.entities.Book;

@Component
public class BookService {

    private static List<Book> list = new ArrayList<Book>();

    @Autowired
    private BookRepository bookRepository;

    // static {
    // list.add(new Book(12, "Java Complete Reference", "XUD"));
    // list.add(new Book(36, "Head first to Java ", "QWE"));
    // list.add(new Book(12963, "THink in Java ", "AABC"));

    // }

    public List<Book> getAllBooks() {
        return (List<Book>) this.bookRepository.findAll();
    }

    public Book getBookById(int id) {
        Book book = null;
        try {
            // book = list.stream().filter(e -> e.getId() == id).findFirst().get();
            book = this.bookRepository.findById(id);
        } catch (Exception e) {
            // TODO: handle exception
        }

        return book;
    }

    public Book addBook(Book b) {
        // list.add(b);

        Book result = this.bookRepository.save(b);
        return result;
    }

    public void deleteBook(int bid) {
        // list = list.stream().filter(book -> book.getId() !=
        // bid).collect(Collectors.toList());
        bookRepository.deleteById(bid);

    }

    public void updateBook(Book book, int bookId) {
        // list = list.stream().map(b -> {
        // if (b.getId() == bookId) {
        // b.setTitle(book.getTitle());
        // b.setAuthor(book.getAuthor());

        // }
        // return b;
        // }).collect(Collectors.toList());

        book.setId(bookId);
        bookRepository.save(book);
    }

}
