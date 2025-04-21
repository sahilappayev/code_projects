package com.example.spring_jdbc.spring_jdbc.repository;

import com.example.spring_jdbc.spring_jdbc.domain.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PersonRepository {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Person> findAll() {
        String sql = "select id, name, surname from persons";

        return jdbcTemplate.query(sql, new PersonRowMapper());
    }

    public Optional<Person> findById(int id) {
        String sql = "select * from persons where id = :id";

        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);
        try {
            return Optional.of(namedParameterJdbcTemplate.queryForObject(sql, params, new PersonRowMapper()));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }


    public Person create(Person person) {
        String sql = "insert into persons (name, surname, email, address, salary) " +
                "values (:name, :surname, :email, :address, :salary) returning *";

        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("name", person.getFirstName())
                .addValue("surname", person.getLastName())
                .addValue("email", person.getEmail())
                .addValue("address", person.getAddress())
                .addValue("salary", person.getSalary());

        return namedParameterJdbcTemplate.query(sql, params, new PersonResultSetExtractor());
    }

    public Person update(int id, Person person) {
        String sql = "update persons set name = :name, surname = :surname, email = :email, address = :address, " +
                "salary = :salary where id = :id returning *";

        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id)
                .addValue("name", person.getFirstName())
                .addValue("surname", person.getLastName())
                .addValue("email", person.getEmail())
                .addValue("address", person.getAddress())
                .addValue("salary", person.getSalary());

        return namedParameterJdbcTemplate.query(sql, params, new PersonResultSetExtractor());
    }

    public void delete(int id) {
        String sql = "delete from persons where id = :id";

        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);

        namedParameterJdbcTemplate.update(sql, params);
    }


    public static class PersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setFirstName(rs.getString("name"));
            person.setLastName(rs.getString("surname"));
            person.setEmail(rs.getString("email"));
            person.setAddress(rs.getString("address"));
            person.setSalary(rs.getBigDecimal("salary"));
            person.setCreatedAt(rs.getTimestamp("created_at"));
            return person;
        }
    }

    public static class PersonResultSetExtractor implements ResultSetExtractor<Person> {

        @Override
        public Person extractData(ResultSet rs) throws SQLException {
            Person person = new Person();
            if (rs.next()) {
                person.setId(rs.getInt("id"));
                person.setFirstName(rs.getString("name"));
                person.setLastName(rs.getString("surname"));
                person.setEmail(rs.getString("email"));
                person.setAddress(rs.getString("address"));
                person.setSalary(rs.getBigDecimal("salary"));
                person.setCreatedAt(rs.getTimestamp("created_at"));
                return person;
            }
            return null;
        }
    }


}
