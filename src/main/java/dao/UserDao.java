package dao;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements DAO {
    public void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS `users` (\n" +
                     " `id` BIGINT NOT NULL AUTO_INCREMENT,\n" +
                     " `name` VARCHAR(45) NOT NULL,\n" +
                     " `age` INT NOT NULL,\n" +
                     "PRIMARY KEY (`id`))";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();
        preparedStatement.close();
    }

    public void dropTable() throws SQLException {
        String sql = "DROP TABLE IF EXISTS `users`";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();
        preparedStatement.close();
    }

    public List<User> getAllUsers() throws SQLException {
        String sql = "SELECT * FROM `users`";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<User> list = new ArrayList<>();

        while (resultSet.next()) {
            list.add(new User(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("age")));
        }

        resultSet.close();
        preparedStatement.close();

        return list;
    }

    public int addUser(String name, int age) throws SQLException {
        User user = getUser(name);
        int rows = 0;

        if (user == null) {
            String sql = "INSERT INTO `users` (`name`, `age`) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);

            rows = preparedStatement.executeUpdate();

            preparedStatement.close();
        } else {
            System.out.println("This name already exists, choose another name:)");
        }

        return rows;
    }

    public User getUser(String name) throws SQLException {
        String sql = "SELECT * FROM `users` WHERE (`name` = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);

        User user;

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            user = new User(resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("age"));
        } else {
            return null;
        }

        resultSet.close();
        preparedStatement.close();

        return user;
    }

    public void updateUser(User user, String name) throws SQLException {
        String sql = "UPDATE `users` SET `name` = ? WHERE (`id` = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setLong(2, user.getId());

        preparedStatement.execute();

        preparedStatement.close();
    }

    public void updateUser(User user, int age) throws SQLException {
        String sql = "UPDATE `users` SET `age` = ? WHERE (`id` = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, age);
        preparedStatement.setLong(2, user.getId());

        preparedStatement.execute();

        preparedStatement.close();
    }

    public void updateUser(User user, Long ID) throws SQLException {
        String sql = "UPDATE `users` SET `id` = ? WHERE (`id` = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, ID);
        preparedStatement.setLong(2, user.getId());

        preparedStatement.execute();

        preparedStatement.close();
    }

    public long getClientIdByName(String name) throws SQLException {
        long id = 0;
        User user = getUser(name);

        if (user == null) {
            return id;
        } else {
            id = user.getId();
        }

        return id;
    }

    public void deleteUserByName(String name) throws SQLException {
        String sql = "DELETE FROM `users` WHERE (`name` = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);

        preparedStatement.execute();
        preparedStatement.close();
    }

    public void deleteUserById(Long id) throws SQLException {
        String sql = "DELETE FROM `users` WHERE (`id` = ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.execute();
        preparedStatement.close();
    }
}
