package io.library.readerlist.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.library.readerlist.domain.Book;
import io.library.readerlist.domain.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(Long authorId) {
        return new ArrayList<>(bookRepository.findByAuthorId(authorId));
    }

    public Book getBook(Long id) {
        return bookRepository.findOne(id);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.delete(id);
    }
}
