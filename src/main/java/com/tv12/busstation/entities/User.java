package com.tv12.busstation.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.criteria.CriteriaBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "users",
       uniqueConstraints = {@UniqueConstraint(name = "email_constraint", columnNames = "email")})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, columnDefinition = "INT")
    private Integer id;

    @Column(name = "email", updatable = false, columnDefinition = "TEXT")
    private String email;

    @Column(name = "password", updatable = false, columnDefinition = "TEXT")
    private String password;

    @Column(name = "role", updatable = false, columnDefinition = "TEXT")
    private String role;
}
