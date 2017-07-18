package io.library.readerlist.service;

import io.library.readerlist.domain.Author;
import io.library.readerlist.domain.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        List<Author> authors = new ArrayList<>();
        authorRepository.findAll().forEach(authors::add);
        return authors;
    }

    public Author getAuthor(Long id) {
        return authorRepository.findOne(id);
    }

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public void updateAuthor(Long id, Author author) {
        Author authorToUpdate = authorRepository.findOne(id);
        authorToUpdate.setName(author.getName());
        authorToUpdate.setLastName(author.getLastName());
        authorRepository.save(authorToUpdate);
    }

    public void deleteAuthor(Long id) {
        authorRepository.delete(id);
    }
}
