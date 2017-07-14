package io.library.readerlist.service;

import io.library.readerlist.web.Author;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class AuthorService {

    private List<Author> allAuthors = new ArrayList<>(Arrays.asList(
            new Author(1L, "John", "Fowles"),
            new Author(2L, "Stephen", "King"),
            new Author(3L, "Agatha", "Christie")));

    public List<Author> getAllAuthors() {
        return allAuthors;
    }

    public Author getAuthor(Long id) {
        return allAuthors.stream().filter(author -> Objects.equals(author.getId(), id)).findFirst().orElse(null);
    }


    public List<Author> addAuthor(Author author) {
        allAuthors.add(author);
        return allAuthors;
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
