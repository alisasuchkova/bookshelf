package db;

import static org.assertj.core.api.Java6Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import io.library.reader.domain.Author;

public class AuthorRepositoryTestDB extends DBBaseTest {
    private Author author;

    @Before
    public void createAuthor() {
        author = new Author("Stephen", "King");
        entityManager.persistAndFlush(author);
    }

    @Test
    public void checkAuthorNameWhenFoundByLastName() {
        Author found = authorRepository.findByLastName(author.getLastName());
        assertThat(found.getName()).isEqualTo(author.getName());
    }

    @Test
    public void checkAuthorLastNameWhenFoundById() {
        Author found = authorRepository.findOne(author.getId());
        assertThat(found.getLastName()).isEqualTo(author.getLastName());
    }
}
