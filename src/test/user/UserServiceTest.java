package user;

import com.lhb.sh.ShopApplication;
import com.lhb.sh.exception.user.UserException;
import com.lhb.sh.mapper.UserMapper;
import com.lhb.sh.model.User;
import com.lhb.sh.service.user.UserService;

import main.ShopApplicationTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;





public class UserServiceTest extends ShopApplicationTest {


    @Resource(name = "dbUserService")
    UserService userService;
    @Test
    public void test() throws UserException {
        System.out.println("Testing");
        User user=new User();
        user.setUsername("lhbasura");
        user.setPassword("abcedfdfdsffsd");
        user.setEmail("fsdfsd@fdsf.com");
        userService.register(user);
    }

}
