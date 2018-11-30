package io.library.reader.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String genre;
    @ManyToOne(cascade = CascadeType.ALL)
    private Author author;

    public Book(Author author, String title, String genre) {
        this.title = title;
        this.genre = genre;
        this.author = new Author(author.getName(), author.getLastName());
    }
}
