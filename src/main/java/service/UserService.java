package service;

import exception.DBException;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService implements Service {
    public void createTable() throws DBException {
        try {
            dao.createTable();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void cleanUp() throws DBException {
        try {
            dao.dropTable();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public List<User> getAllUsers() throws DBException {
        try {
            return dao.getAllUsers();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void addUser(String name, int age) throws DBException {
        try {
            dao.addUser(name, age);
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public User getUserByName(String name) throws DBException {
        try {
            return dao.getUser(name);
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void updateUser(User user, String name) throws DBException {
        try {
            dao.updateUser(user, name);
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void updateUser(User user, int age) throws DBException {
        try {
            dao.updateUser(user, age);
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void updateUser(User user, Long id) throws DBException {
        try {
            dao.updateUser(user, id);
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void deleteUserByName(String name) throws DBException {
        try {
            dao.deleteUserByName(name);
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    @Override
    public void deleteUserById(Long id) throws DBException {
        try {
            dao.deleteUserById(id);
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public long getUserIdByName(String name) throws DBException {
        try {
            return dao.getClientIdByName(name);
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
}
