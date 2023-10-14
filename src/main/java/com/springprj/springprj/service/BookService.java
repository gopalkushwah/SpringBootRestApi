package com.springprj.springprj.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.springprj.springprj.model.Book;

@Component
public class BookService {

    private static List<Book> list = new ArrayList<>();

    static {
        list.add(new Book(101, "java", "xyz"));
        list.add(new Book(102, "c++", "abc"));
        list.add(new Book(103, "c", "mno"));
        list.add(new Book(104, "python", "pqr"));
    }

    public List<Book> getAllBook() {
        return list;
    }

    public Book getBookById(int id) {
        return list.stream().filter(e -> e.getId() == id).findFirst().get();
    }

    public Book addBook(Book book) {
        list.add(book);
        return book;
    }

    public String deleteBook(int id) {
        int size = list.size();
        String b = "Something went wrong";
        list = list.stream().filter(e -> {
            if (e.getId() != id) {
                return true;
            } else
                return false;

        }).collect(Collectors.toList());
        int size1 = list.size();
        if (size != size1)
            b = "Item deleted";
        return b;

    }

    public List<Book> updateBooks(Book book, int id) {
        return list.stream().map(b -> {
            if (b.getId() == id) {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }
}
