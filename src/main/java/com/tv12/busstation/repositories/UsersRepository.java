package com.tv12.busstation.repositories;

import com.tv12.busstation.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
    User findFirstByEmail(String email);
}
