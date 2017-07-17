package io.library.readerlist.service;

import io.library.readerlist.domain.Author;
import io.library.readerlist.domain.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    private List<Author> allAuthors = new ArrayList<>(Arrays.asList(
            new Author(1L, "John", "Fowles"),
            new Author(2L, "Stephen", "King"),
            new Author(3L, "Agatha", "Christie")));

    public List<Author> getAllAuthors() {
        List<Author> authors = new ArrayList<>();
        authorRepository.findAll().forEach(authors::add);
        return authors;
    }

    public Author getAuthor(Long id) {
        return allAuthors.stream().filter(author -> Objects.equals(author.getId(), id)).findFirst().orElse(null);
    }


    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public void updateAuthor(Long id, Author author) {
        for (int i = 0; i < allAuthors.size(); i++) {
            if (allAuthors.get(i).getId().equals(id)) {
                allAuthors.set(i, author);
                return;
            }
        }
    }

    public void deleteAuthor(Long id) {
        allAuthors.removeIf(a -> a.getId().equals(id));
    }
}
