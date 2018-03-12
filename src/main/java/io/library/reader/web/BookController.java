package io.library.reader.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.library.reader.domain.Author;
import io.library.reader.domain.Book;
import io.library.reader.service.BookService;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/authors/{authorId}/books")
    public List<Book> getAllBooks(@PathVariable Long authorId) {
        return bookService.getAllBooks(authorId);
    }

    @GetMapping("/authors/{authorId}/books/{bookId}")
    public Book getBook(@PathVariable Long bookId) {
        return bookService.getBook(bookId);
    }

    @PostMapping("/authors/{authorId}/books")
    public void addBook(@PathVariable Long authorId, @RequestBody Book book) {
        book.setAuthor(new Author(authorId, "", ""));
        bookService.addBook(book);
    }

    @PutMapping("/authors/{authorId}/books/{bookId}")
    public void updateBook(@RequestBody Book book, @PathVariable Long authorId, @PathVariable Long bookId) {
        book.setAuthor(new Author(authorId, "", ""));
        bookService.updateBook(book);
    }

    @DeleteMapping("/authors/{authorId}/books/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
    }
}