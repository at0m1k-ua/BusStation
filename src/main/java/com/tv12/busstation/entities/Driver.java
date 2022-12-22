package com.tv12.busstation.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "drivers",
        uniqueConstraints = {@UniqueConstraint(name = "phone_constraint", columnNames = "phone")})
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, columnDefinition = "INT")
    private Integer id;

    @Column(name = "surname", nullable = false, columnDefinition = "TEXT")
    private String surname;

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(name = "patronymic", nullable = false, columnDefinition = "TEXT")
    private String patronymic;

    @Column(name = "phone", nullable = false, columnDefinition = "TEXT")
    private String phone;

    @Column(name = "email", nullable = false, columnDefinition = "TEXT")
    private String email;

    @Override
    public String toString() {
        return String.join(" ", surname, name, patronymic);
    }
}
