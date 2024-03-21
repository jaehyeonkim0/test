package com.movie.reservation.repository;

import com.movie.reservation.domain.location.Location;
import com.movie.reservation.domain.theater.Theater;
import com.movie.reservation.repository.theater.LocationRepository;
import com.movie.reservation.repository.theater.TheaterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class TheaterTest {

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    LocationRepository locationRepository;

    @Test
    void insert() {
        Location location = new Location("SEOUL");
        locationRepository.save(location);

        Theater theater = new Theater("GANGNAM");
        theater.setLocation(location);
        theaterRepository.save(theater);

        Assertions.assertEquals(location.getTheaters().get(0).getId(), theater.getId());
    }

    @Test
    void getTheaterList() {
        Optional<Location> location = locationRepository.findById(1L);
    }
}
