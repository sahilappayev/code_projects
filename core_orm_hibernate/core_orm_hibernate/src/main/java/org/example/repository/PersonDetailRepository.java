package org.example.repository;

import org.example.config.DbConfig;
import org.example.entity.PersonDetail;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonDetailRepository {

    public PersonDetail findById(int id) {
        try (Session session = DbConfig.getSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            PersonDetail personDetail = session.get(PersonDetail.class, id);
            transaction.commit();
            return personDetail;
        }
    }


}
