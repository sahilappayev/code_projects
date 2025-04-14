package org.example.repository;

import java.util.Optional;
import org.example.config.DbConfig;
import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserRepository {


    public Optional<User> create(User user) {
        try (Session session = DbConfig.getSession()) {
            Transaction transaction = session.getTransaction();

            transaction.begin();

            try {
                Object id = session.save(user);
                user.setId((int) id);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }

            return Optional.ofNullable(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    public Optional<User> findById(int id) {
        try (Session session = DbConfig.getSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            User user = session.get(User.class, id);
            transaction.commit();
            return Optional.ofNullable(user);
        }
    }


}
