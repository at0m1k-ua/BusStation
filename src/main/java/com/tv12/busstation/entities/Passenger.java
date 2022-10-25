package com.tv12.busstation.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String phone;
}
