package com.movie.reservation.domain.theater;

import com.movie.reservation.domain.location.Location;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    public Theater(String name) {
        this.name = name;
    }

    public void setLocation(Location location) {
        this.location = location;
        location.getTheaters().add(this);
    }

}
