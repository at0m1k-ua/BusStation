package com.tv12.busstation.services.impl;

import com.tv12.busstation.entities.BusModel;
import com.tv12.busstation.repositories.BusModelsRepository;
import com.tv12.busstation.services.BusModelsService;
import org.springframework.stereotype.Service;

@Service
public class BusModelsServiceImpl implements BusModelsService {

    private final BusModelsRepository busModelsRepository;

    private BusModelsServiceImpl(BusModelsRepository busModelsRepository) {
        this.busModelsRepository = busModelsRepository;
    }

    @Override
    public void create(String name, int seatsNumber) {
        busModelsRepository.saveAndFlush(new BusModel(null, name, seatsNumber));
    }

    @Override
    public Iterable<BusModel> readAll() {
        return busModelsRepository.findAll();
    }
}
