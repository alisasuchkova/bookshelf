package io.library.reader.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByName(String name);

    Author findByLastName(String lastName);
}
