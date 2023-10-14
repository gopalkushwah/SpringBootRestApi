package com.springprj.springprj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springprj.springprj.model.Book;
import com.springprj.springprj.service.BookService;

@RestController
public class BooksRestController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books/{id}")
    public Book getBooks(@PathVariable("id") int id) {
        return this.bookService.getBookById(id);
    }

    @GetMapping("/books/all")
    public List<Book> getAllBooks() {
        return this.bookService.getAllBook();
    }

    @PostMapping("/books")
    public Book addBooks(@RequestBody Book book) {
        return this.bookService.addBook(book);
    }

    @DeleteMapping("/books/{id}")
    public String deleteBooks(@PathVariable("id") int id) {
        return this.bookService.deleteBook(id);
    }

    @PutMapping("/books/{id}")
    public List<Book> updateBooks(@RequestBody Book book, @PathVariable("id") int id) {
        return this.bookService.updateBooks(book, id);
    }

}
