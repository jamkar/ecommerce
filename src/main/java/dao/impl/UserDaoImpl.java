package dao.impl;

import dao.BaseDao;
import dao.UserDao;
import model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public void add(User user) {
        getSession().persist(user);
    }

    @Override
    public void update(User user) {
        getSession().update(user);
    }

    @Override
    public void delete(long userId) {
        Query query = getSession().createSQLQuery("delete from User where id = :id");
        query.setParameter("id", userId);
        query.executeUpdate();
    }

    @Override
    public User getById(long id) {
        return getSession().get(User.class, id);
    }

    @Override
    public User getByUsername(String username) {
//        Query query = getSession().createQuery("from User where username = :username");
//        query.setString("username", username);
//        return (User) query.uniqueResult();

        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        return (User) criteria.uniqueResult();
    }

    @Override
    public List<User> getAll() {
        Criteria criteria = getSession().createCriteria(User.class);
        return (List<User>)criteria.list();
    }
}
