package com.tv12.busstation.services.impl;

import com.tv12.busstation.entities.BusModel;
import com.tv12.busstation.services.BusModelDAO;
import com.tv12.busstation.services.mappers.BusModelRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class BusModelDAOImpl implements BusModelDAO {

    private JdbcTemplate jdbcTemplate;

    public BusModelDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(String name, int seatsNumber) {

       String sql = """
               INSERT INTO bus_models (name, seats_number)
               VALUES (?, ?)
               """;
         jdbcTemplate.update(sql, name, seatsNumber);
    }

    @Override
    public Iterable<BusModel> readAll() {
        String sql = """
                SELECT id, name, seats_number
                FROM bus_models
                """;
        return jdbcTemplate.query(sql, new BusModelRowMapper());
    }
}
