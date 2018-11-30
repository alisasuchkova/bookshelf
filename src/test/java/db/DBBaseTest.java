package db;

import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.library.reader.Application;
import io.library.reader.domain.AuthorRepository;
import io.library.reader.domain.BookRepository;

/**
 * @RunWith(SpringRunner.class) is used to provide a bridge between Spring Boot test features and JUnit.
 *
 * @DataJpaTest provides some standard setup needed for testing the persistence layer:
 *  - configuring H2, an in-memory database
 *  - setting Hibernate, Spring Data, and the DataSource
 *  - performing an @EntityScan
 *  - turning on SQL logging
 *
 * To carry out some DB operation, we need some records already setup in our database. To setup such data, we can use
 * TestEntityManager.
 *
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = Application.class)
public class DBBaseTest {
    @Autowired
    TestEntityManager entityManager;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;

    @After
    public void clearDB() {
        entityManager.clear();
    }
}
