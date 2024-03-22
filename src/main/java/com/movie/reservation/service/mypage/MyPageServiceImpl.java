package com.movie.reservation.service.mypage;

import com.movie.reservation.domain.member.Member;
import com.movie.reservation.dto.mypage.MemberDto;
import com.movie.reservation.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyPageServiceImpl implements MyPageService {

    private final MemberRepository memberRepository;

    @Override
    public MemberDto getMemberDto(String username) {
        Member memberEntity = memberRepository.findWithRoles(username).orElseThrow(() ->
                new UsernameNotFoundException("해당 사용자가 존재하지 않습니다"));

        //Entity -> DTO
        MemberDto memberDto = memberEntity.toMemberDto();

        return memberDto;
    }
}
