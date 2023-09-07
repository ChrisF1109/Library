import com.config.SpringConfig;
import com.domain.Book;
import com.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class testService {

    @Autowired
    private BookService bookService;

    @Test
    public void getById() {
        Book id = bookService.getById(1);
        System.out.println(id);
    }

    @Test
    public void getByAll(){
        List<Book> all = bookService.getByAll();
        System.out.println(all);
    }
}
