package com.movie.reservation.service.mypage;

import com.movie.reservation.dto.mypage.MemberDto;
import com.movie.reservation.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyPageService {

    private final MemberRepository memberRepository;

    public MemberDto getMemberDto() {
        return null;
    }
}
