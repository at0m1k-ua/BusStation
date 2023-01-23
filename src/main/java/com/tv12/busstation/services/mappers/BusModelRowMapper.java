package com.tv12.busstation.services.mappers;


import com.tv12.busstation.entities.BusModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BusModelRowMapper implements RowMapper<BusModel> {
    @Override
    public BusModel mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new BusModel(resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getInt("seats_number"));
    }
}
