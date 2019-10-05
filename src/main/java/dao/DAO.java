package dao;

import model.User;
import util.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface DAO {
    Connection connection = DBHelper.getMysqlConnection();

    void createTable() throws SQLException;

    void dropTable() throws SQLException;

    List<User> getAllUsers() throws SQLException;

    int addUser(String name, int age) throws SQLException;

    User getUser(String name) throws SQLException;

    void updateUser(User user, String name) throws SQLException;

    void updateUser(User user, int age) throws SQLException;

    void updateUser(User user, Long ID) throws SQLException;

    long getClientIdByName(String name) throws SQLException;

    void deleteUserByName(String name) throws SQLException;

    void deleteUserById(Long id) throws SQLException;
}
