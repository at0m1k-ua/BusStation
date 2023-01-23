package com.tv12.busstation.repositories;

import com.tv12.busstation.entities.City;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

@DataJdbcTest
public class CitiesRepositoryTest {
    @Autowired
    public CitiesRepository underTest;

    @Test
    void itShouldSelectAll() {
        //when
        List<City> result = (List<City>) underTest.findAll();
        //then
        assertEquals(result.isEmpty(), false);
    }
}
