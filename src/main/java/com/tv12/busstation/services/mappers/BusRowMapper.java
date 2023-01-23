package com.tv12.busstation.services.mappers;


import com.tv12.busstation.entities.Bus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BusRowMapper implements RowMapper<Bus> {
    @Override
    public Bus mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Bus(resultSet.getInt("id"),
                resultSet.getInt("model_id"),
                resultSet.getString("color"),
                resultSet.getString("license_plate_number"));
    }
}
