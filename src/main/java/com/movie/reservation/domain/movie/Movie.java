package com.movie.reservation.domain.movie;

import com.movie.reservation.domain.movie.type.MovieType;
import com.movie.reservation.domain.order.Ticket;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String startDate;
    @Column
    private String endDate;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.LAZY)
    private Set<MovieType> movieTypes = new HashSet<>();

    @OneToOne(mappedBy = "movie")
    private Ticket ticket;
}
