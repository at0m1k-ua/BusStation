package com.tv12.busstation;

import com.tv12.busstation.entities.Passenger;
import com.tv12.busstation.repositories.PassengersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class Controller {
    @Autowired
    PassengersRepository passengerRepository;

    @GetMapping("/")
    public Optional<Passenger> getPassengerData(@RequestParam(value = "id", defaultValue = "1") int id) {
        return passengerRepository.findById(id);
    }
}
