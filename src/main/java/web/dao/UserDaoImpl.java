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
    //    @Autowired
//    SessionFactory sessionFactory;
//
//    @Override
//    public List<User> getAllUser() {
//
//        Session session = sessionFactory.getCurrentSession();
//        List<User> allUsers = session.createQuery("from User", User.class)
//                .getResultList();
//        return allUsers;
//    }
//
//    @Override
//    public void saveUser(User user) {
//        Session session = sessionFactory.getCurrentSession();
//        session.saveOrUpdate(user);
//
//    }
//
//    @Override
//    public User getUser(long id) {
//        Session session = sessionFactory.getCurrentSession();
//        User user = session.get(User.class,id);
//        return user;
//    }
//
//    @Override
//    public void deleteUser(long id) {
//        Session session = sessionFactory.getCurrentSession();
//        Query<User> query = session.createQuery("delete from User" +
//                                                    " where id =:userId");
//        query.setParameter("userId", id);
//        query.executeUpdate();
//
//    }
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
