package com.movie.reservation.domain.order;

import com.movie.reservation.domain.member.Member;
import com.movie.reservation.domain.movie.Movie;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

}
