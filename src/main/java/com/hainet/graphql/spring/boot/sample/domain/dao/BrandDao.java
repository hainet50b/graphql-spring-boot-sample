package com.hainet.graphql.spring.boot.sample.domain.dao;

import com.hainet.graphql.spring.boot.sample.domain.entity.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BrandDao {

    private final JdbcTemplate jdbcTemplate;

    public List<Brand> findAll() {
        return this.jdbcTemplate.query(
                "SELECT * FROM brand",
                new BeanPropertyRowMapper<>(Brand.class)
        );
    }

    public Brand findById(final int id) {
        return this.jdbcTemplate.queryForObject(
                "SELECT * FROM brand WHERE id = ?",
                new BeanPropertyRowMapper<>(Brand.class),
                id
        );
    }

    public int insert(final Brand brand) {
        final GeneratedKeyHolder holder = new GeneratedKeyHolder();
        final int result = this.jdbcTemplate.update(con -> {
            final PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO brand (name) VALUES (?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, brand.getName());

            return ps;
        }, holder);
        brand.setId(holder.getKey().intValue());

        return result;
    }
}
