package io.library.reader.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthorId(Long authorId);

    List<Book> findAllByGenre(String genre);

    Book findByTitle(String title);
}
