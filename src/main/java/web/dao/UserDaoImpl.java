package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.user.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager manager;
    @Override
    public List<User> getAllUser() {

        return manager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        manager.persist(user);

    }

    @Override
    public User getUser(long id) {
        return manager.find(User.class, id);
    }

    @Override
    public void deleteUser(long id) {
        manager.remove(getUser(id));

    }

    @Override
    public void updateUser(Long id, User user) {
        manager.merge(user);
    }


}
