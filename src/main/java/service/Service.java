package service;

import dao.UserDao;
import exception.DBException;
import model.User;

import java.util.List;

public interface Service {
    UserDao dao = new UserDao();

    void createTable() throws DBException;

    void cleanUp() throws DBException;

    List<User> getAllUsers() throws DBException;

    void addUser(String name, int age) throws DBException;

    User getUserByName(String name) throws DBException;

    void updateUser(User user, String name) throws DBException;

    void updateUser(User user, int age) throws DBException;

    void updateUser(User user, Long id) throws DBException;

    void deleteUserByName(String name) throws DBException;

    void deleteUserById(Long id) throws DBException;

    long getUserIdByName(String name) throws DBException;
}
