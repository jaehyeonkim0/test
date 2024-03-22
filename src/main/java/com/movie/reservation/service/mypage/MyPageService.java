package com.movie.reservation.service.mypage;

import com.movie.reservation.dto.mypage.MemberDto;

public interface MyPageService {

    MemberDto getMemberDto(String username);
}
