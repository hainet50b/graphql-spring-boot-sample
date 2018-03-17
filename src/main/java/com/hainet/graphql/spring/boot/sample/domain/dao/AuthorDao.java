package com.hainet.graphql.spring.boot.sample.domain.dao;

import com.hainet.graphql.spring.boot.sample.domain.model.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AuthorDao {

    private final JdbcTemplate jdbcTemplate;

    public List<Author> findAll() {
        return this.jdbcTemplate.query("SELECT * FROM author", new BeanPropertyRowMapper<>(Author.class));
    }

    public Author findById(final int id) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM author WHERE id = ?", new BeanPropertyRowMapper<>(Author.class), id);
    }

    public int insert(final Author author) {
        final int result = this.jdbcTemplate.update("INSERT INTO author (name) VALUES (?)", author.getName());
        author.setId(this.findAll().stream().map(Author::getId).max(Comparator.naturalOrder()).get());

        return result;
    }
}
