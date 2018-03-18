package com.hainet.graphql.spring.boot.sample.domain.dao;

import com.hainet.graphql.spring.boot.sample.domain.model.Publisher;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PublisherDao {

    private final JdbcTemplate jdbcTemplate;

    public List<Publisher> findAll() {
        return this.jdbcTemplate.query("SELECT * FROM publisher", new BeanPropertyRowMapper<>(Publisher.class));
    }

    public Publisher findById(final int id) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM publisher WHERE id = ?", new BeanPropertyRowMapper<>(Publisher.class), id);
    }

    public int insert(final Publisher publisher) {
        final int result = jdbcTemplate.update("INSERT INTO publisher (name) VALUES (?)", publisher.getName());
        publisher.setId(this.findAll().stream().map(Publisher::getId).max(Comparator.naturalOrder()).orElse(0));

        return result;
    }
}
