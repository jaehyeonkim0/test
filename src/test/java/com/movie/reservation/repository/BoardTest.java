package com.movie.reservation.repository;

import com.movie.reservation.domain.board.Board;
import com.movie.reservation.domain.member.Member;
import com.movie.reservation.repository.board.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Log4j2
class BoardTest {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("게시판 작성")
    void insertBoard() {
        Optional<Member> memberOptional = memberRepository.findByUsername("test3");
        Member member = memberOptional.orElseThrow();

//        Board board = new Board("게시판 제목6", "게시판 내용6");
//        board.insertMember(member);
//        boardRepository.save(board);
    }

    @Transactional
    @Test
    @DisplayName("게시판 조회")
    void getBoard() {
        Optional<Board> board = boardRepository.findById(2L);
        Board board1 = board.get();

        Member member = board1.getMember();
    }
}
