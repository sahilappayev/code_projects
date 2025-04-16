package org.example.repository;

import org.example.config.DbConfig;
import org.example.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TeacherRepository {

    public Teacher findById(int id) {
        try (Session session = DbConfig.getSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            Teacher teacher = session.get(Teacher.class, id);
            transaction.commit();
            return teacher;
        }
    }


}
