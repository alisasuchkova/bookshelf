package io.library.readerlist.web;

import lombok.Data;

@Data
public class Author {

    private Long id;
    private String name;
    private String lastName;

    public Author() {
    }

    public Author(Long id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }
}
