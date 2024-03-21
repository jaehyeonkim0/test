package com.movie.reservation.service.test;

import com.movie.reservation.domain.board.Board;
import com.movie.reservation.domain.member.Member;
import com.movie.reservation.dto.board.BoardDto;
import com.movie.reservation.dto.mypage.MemberDto;
import com.movie.reservation.repository.MemberRepository;
import com.movie.reservation.repository.board.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestServiceImpl implements TestService {

    private BoardRepository boardRepository;
    private MemberRepository memberRepository;

    @Autowired
    public TestServiceImpl(BoardRepository boardRepository, MemberRepository memberRepository) {
        this.boardRepository = boardRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public BoardDto getBoard(Long id) {
        Optional<Board> optionalBoard = boardRepository.findById(id);

        if(optionalBoard.isPresent()) {
            Board board = optionalBoard.get();
            BoardDto boardDto = BoardDto.toBoardDto(board);

            return boardDto;
        }
        return null;
    }

    @Override
    public MemberDto getMember(Long id) {
        Optional<Member> optionalMember = memberRepository.findById(1L);

        if(optionalMember.isPresent()) {
            Member member = optionalMember.get();
            MemberDto memberDto = MemberDto.toMemberDto(member);

            return memberDto;
        }
        return null;
    }
}
