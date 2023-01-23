package com.tv12.busstation.services.impl;

import com.tv12.busstation.entities.Bus;
import com.tv12.busstation.entities.BusModel;
import com.tv12.busstation.services.BusDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BusDAOImpl implements BusDAO {

    private JdbcTemplate jdbcTemplate;

    public BusDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(int modelId, String color, String licensePlateNumber) {
        Optional<BusModel> optionalModel = busModelsRepository.findById(modelId);
        if (optionalModel.isEmpty()) {
            throw new RuntimeException();
        }
        BusModel model = optionalModel.get();
        Bus bus = new Bus(null, model, color, licensePlateNumber);
        busesRepository.save(bus);
    }

    @Override
    public Iterable<Bus> readAll() {
        String sql = """
                SELECT id, model_id, color, license_plate_number
                FROM buses
                """;
        return jdbcTemplate.query(sql, new BusRowMapper());
    }

    @Override
    public void update(int id, int modelId, String color, String licensePlateNumber) {
        BusModel model = busModelsRepository.findById(modelId).get();
        Bus bus = new Bus(id, model, color, licensePlateNumber);
        busesRepository.save(bus);
    }

    @Override
    public void delete(int id) {
        busesRepository.deleteById(id);
    }
}
