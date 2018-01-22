package service;

import model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users;

    public UserService() {
        users = new ArrayList<>();
        users.add(new User(1, "John", "Benedict", "jkfdjfhkjdf"));
        users.add(new User(2, "Kate", "Midlton", "jhkhkjhk"));
        users.add(new User(3, "Joe", "Cocker", "fdklfjldkjf"));
        users.add(new User(4, "Donald", "Trump", "fdkjfdlfj"));
        users.add(new User(5, "Tim", "Cook", "fdjhfkj"));
    }

    public User getUser(long id) {
        return users.get((int)id);
    }

    public List<User> getUsers() {
        return users;
    }

    public void updateUser(long id, User user) {
        users.set((int)id, user);
    }

    public void deleteUser(long id) {
        users.remove((int)id);
    }
}
