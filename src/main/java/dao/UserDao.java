package dao;

import model.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    void update(User user);

    void delete(long id);

    User getById(long id);

    User getByUsername(String username);

    List<User> getAll();

}
