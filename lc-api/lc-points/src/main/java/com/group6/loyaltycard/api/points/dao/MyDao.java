package com.group6.loyaltycard.api.points.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class MyDao {
    @Autowired
    private DataSource dataSource;

    public void save(User entity) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("INSERT INTO User (userName, email, cardId, region, regionName) VALUES (?, ?, ?, ?, ?)",
                entity.getUserName(), entity.getEmail(), entity.getCardId(), entity.getRegion(), entity.getRegionName());
    }

    public User findById(Long id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.queryForObject("SELECT * FROM User WHERE userId = ?",
                new Object[] { id },
                (rs, rowNum) -> {
                    User entity = new User();
                    entity.setUserId(rs.getInt("userId"));
                    entity.setEmail(rs.getString("email"));
                    entity.setUserName(rs.getString("userName"));
                    entity.setCardId(rs.getInt("cardId"));
                    entity.setRegion(rs.getInt("region"));
                    entity.setRegionName(rs.getString("regionName"));

                    // set other properties from the result set
                    System.out.println("DBTest -> userName: " + entity.getUserName());
                    return entity;
                });
    }

    public void update(User entity) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("UPDATE User SET email = ? WHERE userId = ?",
                entity.getEmail());
    }

    public void delete(Long id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("DELETE FROM User WHERE userId = ?", id);
    }
}

