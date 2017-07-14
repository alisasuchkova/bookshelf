package io.library.readerlist.web;

import io.library.readerlist.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @RequestMapping("/authors/{id}")
    public Author getAuthor(@PathVariable Long id) {
        return authorService.getAuthor(id);
    }

    @PostMapping("/authors")
    public List<Author> addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
        return authorService.getAllAuthors();
    }
}
