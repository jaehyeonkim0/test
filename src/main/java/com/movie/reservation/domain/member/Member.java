package com.movie.reservation.domain.member;

import com.movie.reservation.domain.board.Board;
import com.movie.reservation.domain.member.role.MemberRole;
import com.movie.reservation.domain.order.Ticket;
import com.movie.reservation.dto.mypage.MemberDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String email;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.LAZY)
    private Set<MemberRole> roles = new HashSet<>();

    @OneToMany(mappedBy = "member")
    private List<Board> boardList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Ticket> tickets = new ArrayList<>();

    @Builder
    public Member(String username, String password, String name, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public void addRole(MemberRole memberRole) {
        this.roles.add(memberRole);
    }

    public void addBoard(Board board) {
        this.boardList.add(board);
    }

    public MemberDto toMemberDto() {
        MemberDto memberDto = new MemberDto();
        memberDto.setUsername(this.getUsername());
        memberDto.setName(this.getName());
        memberDto.setEmail(this.getEmail());

        return memberDto;
    }



}
