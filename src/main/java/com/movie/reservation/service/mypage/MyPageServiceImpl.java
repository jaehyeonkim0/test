package com.movie.reservation.service.mypage;

import com.movie.reservation.dto.mypage.MemberDto;
import com.movie.reservation.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyPageServiceImpl implements MyPageService {

    private final MemberRepository memberRepository;

    @Override
    public MemberDto getMemberDto(String username) {
        return null;
    }
}
