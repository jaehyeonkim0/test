package com.movie.reservation.dto.mypage;

import com.movie.reservation.domain.member.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {

    private String username;
    private String name;
    private String email;


    public static MemberDto toMemberDto(Member member) {
        MemberDto memberDto = new MemberDto();
        memberDto.setUsername(member.getUsername());
        memberDto.setName(member.getName());
        memberDto.setEmail(member.getEmail());

        return memberDto;
    }
}
