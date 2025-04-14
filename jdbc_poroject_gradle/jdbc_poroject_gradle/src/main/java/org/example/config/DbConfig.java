package org.example.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;
import org.postgresql.Driver;

public class DbConfig {

    private static DbConfig instance;
    private static final Object lock = new Object();

    private DbConfig() {
    }

    public static DbConfig getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (lock) {
                if (Objects.isNull(instance)) {
                    instance = new DbConfig();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        Properties props = new Properties();
        props.setProperty("user", "sahil");
        props.setProperty("password", "mypassword");

        try {
            return new Driver().connect("jdbc:postgresql://127.0.0.1:5433/postgres", props);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
