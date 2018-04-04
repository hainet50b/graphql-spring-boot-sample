package com.hainet.graphql.spring.boot.sample.domain.dao;

import com.hainet.graphql.spring.boot.sample.domain.entity.Brand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BrandDao {

    private final JdbcTemplate jdbcTemplate;

    public List<Brand> findAll() {
        final String query = "SELECT * FROM brand";

        log.info(query);
        return this.jdbcTemplate.query(
                query,
                new BeanPropertyRowMapper<>(Brand.class)
        );
    }

    public Brand findById(final int id) {
        final String query = "SELECT * FROM brand WHERE id = ?";

        log.info(query);
        return this.jdbcTemplate.queryForObject(
                query,
                new BeanPropertyRowMapper<>(Brand.class),
                id
        );
    }

    public int insert(final Brand brand) {
        final String query = "INSERT INTO brand (name) VALUES (?)";

        log.info(query);
        final int result = this.jdbcTemplate.update(query, brand.getName());
        brand.setId(this.jdbcTemplate.queryForObject(
                "SELECT MAX(id) FROM brand",
                Integer.class
        ));

        return result;
    }
}
