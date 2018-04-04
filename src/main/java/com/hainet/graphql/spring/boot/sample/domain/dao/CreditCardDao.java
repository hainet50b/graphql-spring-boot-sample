package com.hainet.graphql.spring.boot.sample.domain.dao;

import com.hainet.graphql.spring.boot.sample.domain.entity.CreditCard;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CreditCardDao {

    private final JdbcTemplate jdbcTemplate;

    public List<CreditCard> findAll() {
        final String query = "SELECT * FROM credit_card";

        log.info(query);
        return this.jdbcTemplate.query(
                query,
                new BeanPropertyRowMapper<>(CreditCard.class)
        );
    }

    public int insert(final CreditCard creditCard) {
        final String query = "INSERT INTO credit_card (number, good_thru, brand_id, security_code) VALUES (?, ?, ?, ?)";

        log.info(query);
        final int result = this.jdbcTemplate.update(
                query,
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
