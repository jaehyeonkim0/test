package com.movie.reservation.service.test;

import com.movie.reservation.dto.board.BoardDto;
import com.movie.reservation.dto.mypage.MemberDto;

public interface TestService {

    BoardDto getBoard(Long id);

    MemberDto getMember(Long id);
}
