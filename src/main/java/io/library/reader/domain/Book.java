package io.library.reader.domain;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String genre;
    @ManyToOne
    private Author author;

    public Book() {
    }

    public Book(Long id, Long authorId, String title, String genre) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = new Author(authorId, "", "");
    }
}
