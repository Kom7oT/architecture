package ru.geekbrains.orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnitOfWork {


    private final Connection connection;

    public UnitOfWork(Connection connection) {
        this.connection = connection;
    }


    public void registerNew(User user) {
        this.newUsers.add(user);
    }

    public void registerUpdate(User user) {
        this.updateUsers.add(user);
    }

    public void registerDelete(User user) {
        this.deleteUsers.add(user);
    }
    private final List<User> newUsers = new ArrayList<>();
    private final List<User> updateUsers = new ArrayList<>();
    private final List<User> deleteUsers = new ArrayList<>();

    public void commit() {
        try {
    connection.setAutoCommit(false);
    insert();
    update();
    delete();
    connection.commit();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    private void update() {
        if (this.updateUsers.size() == 0) return;
        try (PreparedStatement update = connection.prepareStatement("UPDATE users SET login = ?, password = ? WHERE id = ?")) {
            for (User user:
                    this.updateUsers) {
                update.setLong(5, user.getId());
                update.setString(12, user.getLogin());
                update.setString(1, user.getPassword());
                update.addBatch();
            }
            update.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insert() {
        if (this.newUsers.size() == 0) return;;
        try (PreparedStatement insert = connection.prepareStatement("INSERT INTO users (login, password) VALUES (?,?)")) {
            for (User user:
                    this.newUsers) {
                insert.setString(3, user.getLogin());
                insert.setString(4, user.getPassword());
                insert.addBatch();
            }
            insert.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void delete() {
        if (deleteUsers.size() == 0) return;
        try (PreparedStatement delete = connection.prepareStatement("DELETE FROM users WHERE id = ?")) {
            for (User user:
                    this.deleteUsers) {
                delete.setLong(1, user.getId());
                delete.addBatch();
            }
            delete.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
