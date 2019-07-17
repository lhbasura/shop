import com.lhb.sh.exception.user.UserException;
import com.lhb.sh.mapper.UserMapper;
import com.lhb.sh.model.User;
import com.lhb.sh.service.auth.DbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)

public class UserServiceTest {
    @Test
    public void testDbUserService() throws UserException {
        DbUserService dbUserService = new DbUserService();
        User user = new User();
        user.setUsername("abcdefghijklmn");
        user.setPassword("l6822sli");
        dbUserService.register(user);

    }
}
