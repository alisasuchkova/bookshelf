package io.library.reader.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.library.reader.domain.Author;
import io.library.reader.domain.AuthorRepository;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return new ArrayList<>(authorRepository.findAll());
    }

    public Author getAuthor(Long id) {
        return authorRepository.findOne(id);
    }

    public void addAuthors(List<Author> authors) {
        authorRepository.save(authors);
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
