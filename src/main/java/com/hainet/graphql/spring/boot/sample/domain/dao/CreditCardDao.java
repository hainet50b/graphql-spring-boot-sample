package com.hainet.graphql.spring.boot.sample.domain.dao;

import com.hainet.graphql.spring.boot.sample.domain.entity.CreditCard;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CreditCardDao {

    private final JdbcTemplate jdbcTemplate;

    public List<CreditCard> findAll() {
        return this.jdbcTemplate.query(
                "SELECT * FROM credit_card",
                new BeanPropertyRowMapper<>(CreditCard.class)
        );
    }

    public int insert(final CreditCard creditCard) {
        final int result = this.jdbcTemplate.update(
                "INSERT INTO credit_card (number, good_thru, brand_id, security_code) VALUES (?, ?, ?, ?)",
                creditCard.getNumber(),
                creditCard.getGoodThru(),
                creditCard.getBrandId(),
                creditCard.getSecurityCode()
        );
        creditCard.setId(this.jdbcTemplate.queryForObject(
                "SELECT MAX(id) FROM credit_card",
                Integer.class
        ));

        return result;
    }
}
