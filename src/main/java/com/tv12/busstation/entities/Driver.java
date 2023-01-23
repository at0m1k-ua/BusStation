package com.tv12.busstation.entities;

import lombok.*;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@AccessType(AccessType.Type.PROPERTY)
@Table(name = "drivers")
public class Driver {
    @Id
    @Column(value = "id")
    private Integer id;

    @Column(value = "surname")
    private String surname;

    @Column(value = "name")
    private String name;

    @Column(value = "patronymic")
    private String patronymic;

    @Column(value = "phone")
    private String phone;

    @Column(value = "email")
    private String email;

    @Override
    public String toString() {
        return String.join(" ", surname, name, patronymic);
    }
}
