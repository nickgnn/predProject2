package service;

import dao.UserDaoByHibernate;
import exception.DBException;
import model.User;
import org.hibernate.SessionFactory;
import util.DBHelper;

import java.sql.SQLException;
import java.util.List;

public class UserService implements Service {
    private static UserService userService;
    private SessionFactory sessionFactory;

    public UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService(DBHelper.getSessionFactory());
        }

        return userService;
    }

    public void addUser(String name, int age) throws DBException {
        try {
            new UserDaoByHibernate(sessionFactory.openSession()).addUser(name, age);
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public List<User> getAllUsers() throws DBException {
        try {
            return new UserDaoByHibernate(sessionFactory.openSession()).getAllUsers();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public User getUserByName(String name) throws DBException {
        try {
            return new UserDaoByHibernate(sessionFactory.openSession()).getUserByName(name);
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public long getUserIdByName(String name) throws DBException {
        try {
            return new UserDaoByHibernate(sessionFactory.openSession()).getUserIdByName(name);
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void updateUser(User user, String name) throws DBException {
        try {
            new UserDaoByHibernate(sessionFactory.openSession()).updateUser(user, name);
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void updateUser(User user, int age) throws DBException {
        try {
            new UserDaoByHibernate(sessionFactory.openSession()).updateUser(user, age);
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void updateUser(User user, Long id) throws DBException {
        try {
            new UserDaoByHibernate(sessionFactory.openSession()).updateUser(user, id);
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void deleteUserByName(String name) throws DBException {
        try {
            new UserDaoByHibernate(sessionFactory.openSession()).deleteUserByName(name);
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    @Override
    public void deleteUserById(Long id) throws DBException {
        try {
            new UserDaoByHibernate(sessionFactory.openSession()).deleteUserById(id);
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void createTable() throws DBException {
        try {
            new UserDaoByHibernate(sessionFactory.openSession()).createTable();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void cleanUp() throws DBException {
        try {
            new UserDaoByHibernate(sessionFactory.openSession()).dropTable();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
}
