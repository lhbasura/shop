package main;

import com.lhb.sh.ShopApplication;
import com.lhb.sh.exception.user.UserException;
import com.lhb.sh.mapper.UserMapper;
import com.lhb.sh.model.User;
import com.lhb.sh.service.user.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)


public class ShopApplicationTest {
    @Before
    public void init() {

        System.out.println("Test Begin-----------------");

    }


    @Resource(name = "dbUserService")
    UserService userService;
    @Test
    public void test() throws UserException {
        System.out.println("Testing");
        User user=new User();
        user.setUsername("lhbasura");
        user.setPassword("abcedfdfdsffsd");
        userService.register(user);
    }
    @After
    public void after() {

        System.out.println("Test End-----------------");

    }
}
