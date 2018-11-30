package db;

import static org.assertj.core.api.Java6Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import io.library.reader.domain.Author;
import io.library.reader.domain.Book;

public class BookRepositoryTest extends DBBaseTest {

    private Author author;

    @Before
    public void createAuthor() {
        author = new Author("Stephen", "King");
        entityManager.persistAndFlush(author);
    }

    @Test
    public void checkBookGenreWhenFoundByTitle() {
        Book book = new Book(author, "The Shining", "horror");
        entityManager.persistAndFlush(book);

        Book found = bookRepository.findByTitle(book.getTitle());
        assertThat(found.getGenre()).isEqualTo(book.getGenre());
    }

    @Test
    public void checkBookTitleWhenFoundByGenre() {
        Book book = new Book(author, "Misery", "psychological horror thriller");
        entityManager.persistAndFlush(book);

        List<Book> found = bookRepository.findAllByGenre(book.getGenre());
        assertThat(found.get(0).getTitle()).isEqualTo(book.getTitle());
    }
}
