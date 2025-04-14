package org.example.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.example.config.DbConfig;
import org.example.domain.Person;

public class PersonDAO {


    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();

        try (Connection conn = DbConfig.getInstance().getConnection()) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM persons");

            while (rs.next()) {
                Person person = getPersonFromResultSet(rs);
                persons.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    public Optional<Person> findById(int id) {
        Optional<Person> personOptional = Optional.empty();

        try (Connection connection = DbConfig.getInstance().getConnection()) {
            String sql = "SELECT * FROM persons WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Person person = getPersonFromResultSet(resultSet);
                personOptional = Optional.of(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personOptional;
    }

    public Person update(int id, Person person) {
        try (Connection connection = DbConfig.getInstance().getConnection()) {
            String sql = "UPDATE persons set name = ?, surname = ?, created_at = ?  WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, person.getName());
            statement.setString(2, person.getSurname());
            statement.setDate(3, new Date(person.getCreatedAt().getTime()));

            statement.setInt(4, id);

            statement.executeUpdate();

            return findById(id).get();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Person getPersonFromResultSet(ResultSet rs) {
        Person person = new Person();

        try {
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setSurname(rs.getString("surname"));
            person.setEmail(rs.getString("email"));
            person.setAddress(rs.getString("address"));
            person.setSalary(rs.getBigDecimal("salary"));
            person.setCreatedAt(rs.getTimestamp("created_at"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person;
    }

}
