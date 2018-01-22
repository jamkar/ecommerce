package dao;

import model.User;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {config.RootConfig.class})
public class UserDaoTest {

//    @Autowired
    private UserDao userDao;

//    @Test
    public void testAddAndGet() {
        User user = createUser();
        userDao.add(user);
        assertNotNull(user);
    }

    private User createUser() {
        User user = new User();
        user.setPasswordHash("fdfdfd");
        user.setUsername("dsdsdss");
        return user;
    }


}
