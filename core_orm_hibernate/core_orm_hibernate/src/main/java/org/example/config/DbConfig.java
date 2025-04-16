package org.example.config;

import java.util.Properties;
import org.example.entity.Person;
import org.example.entity.PersonDetail;
import org.example.entity.Student;
import org.example.entity.Teacher;
import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class DbConfig {

    private static SessionFactory sessionFactory;

    // SessionFactory, Session, Configuration, Transaction

    private DbConfig() {
    }

    public static Session getSession() {

        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            Properties properties = new Properties();

            properties.put(Environment.JAKARTA_JDBC_URL, "jdbc:postgresql://localhost:5433/postgres");
            properties.put(Environment.JAKARTA_JDBC_USER, "sahil");
            properties.put(Environment.JAKARTA_JDBC_PASSWORD, "mypassword");
            properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            properties.put(Environment.AUTOCOMMIT, "false");
//            properties.put(Environment.JAKARTA_JDBC_DRIVER, "org.postgresql.Driver");
            properties.put(Environment.HBM2DDL_AUTO, "update");  // none, create, validate,   liquibase or flyaway
            properties.put(Environment.POOL_SIZE, "20");

            configuration.addProperties(properties);

            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Person.class);
            configuration.addAnnotatedClass(PersonDetail.class);
            configuration.addAnnotatedClass(Teacher.class);
            configuration.addAnnotatedClass(Student.class);

            sessionFactory = configuration.buildSessionFactory();
        }

        return sessionFactory.getCurrentSession();

    }


}
