package org.example.repository;

import org.example.config.DbConfig;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentRepository {

    public Student findById(int id) {
        try (Session session = DbConfig.getSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            Student student = session.get(Student.class, id);
            transaction.commit();
            return student;
        }
    }


}
