package com.springprj.springprj.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Book> getBooks(@PathVariable("id") int id) {
        Book book = this.bookService.getBookById(id);
        if (book == null) // if list empty then it will send status cod Not found 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.of(Optional.of(book)); // otherwise it will send 200 ok
    }

    @GetMapping("/books/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> list = this.bookService.getAllBook();
        if (list.size() <= 0) // if list empty then it will send status cod Not found 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.of(Optional.of(list)); // otherwise it will send 200 ok

    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBooks(@RequestBody Book book) {
        Book b = null;
        try {
            b = this.bookService.addBook(book);
            return ResponseEntity.of(Optional.of(b));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
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
