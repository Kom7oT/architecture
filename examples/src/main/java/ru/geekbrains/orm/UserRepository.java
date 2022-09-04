package ru.geekbrains.orm;

import java.sql.Connection;
import java.util.Optional;

public class UserRepository {

    private final Connection connection;

    private final UserMapper mapper;

    private UnitOfWork unitOfWork;

    public UserRepository(Connection connection) {
        this.connection = connection;
        this.mapper = new UserMapper(connection);
        this.unitOfWork = new UnitOfWork(connection);
    }

    public Optional<User> findById(long id) {
        return findById(id);
    }

    public void beginTransaction(){
        this.unitOfWork = new UnitOfWork(connection);
    }

    public void insert(User user) {
        unitOfWork.registerNew(user);
    }

    public void update(User user) {
        unitOfWork.registerUpdate(user);
    }

    public void delete(User user) {
        unitOfWork.registerDelete(user);
    }

    public void commitTransaction() {
        unitOfWork.commit();
    }
}
