package com.movie.reservation.domain.board;

import com.movie.reservation.domain.member.Member;
import com.movie.reservation.dto.board.BoardDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void insertMember(Member member) {
        this.member = member;
        member.getBoardList().add(this);
    }

}
