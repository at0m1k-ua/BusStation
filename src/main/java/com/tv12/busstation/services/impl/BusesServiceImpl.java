package com.tv12.busstation.services.impl;

import com.tv12.busstation.entities.Bus;
import com.tv12.busstation.entities.BusModel;
import com.tv12.busstation.repositories.BusModelsRepository;
import com.tv12.busstation.repositories.BusesRepository;
import com.tv12.busstation.services.BusesService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BusesServiceImpl implements BusesService {

    private final BusesRepository busesRepository;
    private final BusModelsRepository busModelsRepository;

    public BusesServiceImpl(BusesRepository busesRepository,
                            BusModelsRepository busModelsRepository) {
        this.busesRepository = busesRepository;
        this.busModelsRepository = busModelsRepository;
    }

    @Override
    public void create(int modelId, String color, String licensePlateNumber) {
        Optional<BusModel> optionalModel = busModelsRepository.findById(modelId);
        if (optionalModel.isEmpty()) {
            throw new RuntimeException();
        }
        BusModel model = optionalModel.get();
        Bus bus = new Bus(null, model, color, licensePlateNumber);
        busesRepository.saveAndFlush(bus);
    }

    @Override
    public Iterable<Bus> readAll() {
        return busesRepository.findAll();
    }

    @Override
    public void update(int id, int modelId, String color, String licensePlateNumber) {
        BusModel model = busModelsRepository.findById(modelId).get();
        Bus bus = new Bus(id, model, color, licensePlateNumber);
        busesRepository.saveAndFlush(bus);
    }

    @Override
    public void delete(int id) {
        busesRepository.deleteById(id);
    }
}
