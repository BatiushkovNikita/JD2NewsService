package testing;

import by.news.service.daojpa.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

@SpringApplicationContext("test-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringJpaTest {

    @SpringBean("userRepository")
    protected UserRepository userRepository;

    @Test
    public void test() {
        userRepository.findUser(1);
    }

}
