package api;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import io.library.reader.domain.BookRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    private TestRestTemplate template;
    @Autowired
    private BookRepository bookRepository;

}
