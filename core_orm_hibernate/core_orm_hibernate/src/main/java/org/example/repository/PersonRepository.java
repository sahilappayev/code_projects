package org.example.repository;

import org.example.config.DbConfig;
import org.example.entity.Person;
import org.example.entity.PersonDetail;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonRepository {


    public Person findById(int id) {
        try (Session session = DbConfig.getSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            Person person = session.get(Person.class, id);
            transaction.commit();
            return person;
        }
    }


}
