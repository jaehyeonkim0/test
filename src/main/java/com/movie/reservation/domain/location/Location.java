package com.movie.reservation.domain.location;

import com.movie.reservation.domain.theater.Theater;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
    private List<Theater> theaters = new ArrayList<>();

    public Location(String name) {
        this.name = name;
    }
}
