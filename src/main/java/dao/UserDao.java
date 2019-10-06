package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.hibernate.hql.internal.antlr.HqlTokenTypes.UPDATE;

public class UserDao implements DAO {
    private Session session;

    public UserDao(Session session) {
        this.session = session;
    }

    public void addUser(String name, int age) throws SQLException {
        User user = getUserByName(name);

        if (user == null) {
            Transaction transaction = session.beginTransaction();
            session.save(new User(name, age));
            transaction.commit();
            session.close();
        } else {
            System.out.println("This name already exists, choose another name:)");
        }
    }

    public List<User> getAllUsers() throws SQLException {
        Transaction transaction = session.beginTransaction();
        List<User> users = session.createQuery("FROM User").list();
        transaction.commit();
        session.close();

        return users;
    }

    public User getUserByName(String name) throws SQLException {
        return (User) session.createCriteria(User.class)
                .add(Restrictions.eq("name", name))
                .uniqueResult();
    }

    public long getUserIdByName(String name) throws SQLException {
        long id = 0;
        User user = getUserByName(name);

        if (user == null) {
            return id;
        } else {
            id = user.getId();
        }

        return id;
    }

    public void updateUser(User user, String name) throws SQLException {
        Transaction transaction = session.beginTransaction();
        session.update(name, user);
        transaction.commit();
        session.close();
    }

    public void updateUser(User user, int age) throws SQLException {
        Transaction transaction = session.beginTransaction();
        session.update(String.valueOf(age), user);
        transaction.commit();
        session.close();
    }

    public void updateUser(User user, Long ID) throws SQLException {
        Transaction transaction = session.beginTransaction();
        session.update(String.valueOf(ID), user);
        transaction.commit();
        session.close();
    }

    public void deleteUserByName(String name) throws SQLException {
        Transaction transaction = session.beginTransaction();
        session.delete(getUserByName(name));
        transaction.commit();
        session.close();
    }

    public void deleteUserById(Long id) throws SQLException {
        Transaction transaction = session.beginTransaction();
        String hql = "DELETE User WHERE id = :id";
        Query query = session.createQuery(hql);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    public void createTable() throws SQLException {
//        String sql = "CREATE TABLE IF NOT EXISTS `users` (\n" +
//                     " `id` BIGINT NOT NULL AUTO_INCREMENT,\n" +
//                     " `name` VARCHAR(45) NOT NULL,\n" +
//                     " `age` INT NOT NULL,\n" +
//                     "PRIMARY KEY (`id`))";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.execute();
//        preparedStatement.close();
    }

    public void dropTable() throws SQLException {
//        String sql = "DROP TABLE IF EXISTS `users`";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.execute();
//        preparedStatement.close();
    }
}
