package com.hainet.graphql.spring.boot.sample.domain.dao;

import com.hainet.graphql.spring.boot.sample.domain.entity.ValidatedCreditCard;
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
public class ValidatedCreditCardDao {

    private final JdbcTemplate jdbcTemplate;

    public List<ValidatedCreditCard> findAll() {
        return this.jdbcTemplate.query(
                "SELECT * FROM credit_card",
                new BeanPropertyRowMapper<>(ValidatedCreditCard.class)
        );
    }

    public int insert(final ValidatedCreditCard creditCard) {
        final GeneratedKeyHolder holder = new GeneratedKeyHolder();
        final int result = this.jdbcTemplate.update(con -> {
            final PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO credit_card (number, good_thru, brand_id, security_code) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, creditCard.getNumber());
            ps.setObject(2, creditCard.getGoodThru());
            ps.setInt(3, creditCard.getBrandId());
            ps.setString(4, creditCard.getSecurityCode());

            return ps;
        }, holder);
        creditCard.setId(holder.getKey().intValue());

        return result;
    }
}
