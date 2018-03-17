package com.hainet.graphql.spring.boot.sample.domain.dao;

import com.hainet.graphql.spring.boot.sample.domain.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookDao {

    private final JdbcTemplate jdbcTemplate;

    public List<Book> findAll() {
        return this.jdbcTemplate.query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));
    }

    public int insert(final Book book) {
        final int result = jdbcTemplate.update("INSERT INTO book (title, author_id) VALUES (?, ?)", book.getTitle(), book.getAuthorId());
        book.setId(this.findAll().stream().map(Book::getId).max(Comparator.naturalOrder()).orElse(0));

        return result;
    }
}
