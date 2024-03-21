package com.movie.reservation.repository;

import com.movie.reservation.domain.board.Board;
import com.movie.reservation.domain.member.Member;
import com.movie.reservation.domain.member.role.MemberRole;
import jakarta.persistence.*;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Log4j2
class MemberTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Test
    void saveMember() {
        Member member = Member.builder()
                .username("test3")
                .password(bCryptPasswordEncoder.encode("123"))
                .name("테스트3")
                .email("test3@naver.com")
                .build();
        member.addRole(MemberRole.USER);
        log.info("before saving member board class = {}", member.getBoardList().getClass());

        memberRepository.save(member);
        log.info("after saving member board class = {}", member.getBoardList().getClass());

    }

    @Test
    @Transactional
    void getMember() {
        Member member = memberRepository.findById(1L).orElseThrow();
    }

    @Test
    void getMemberWithRole() {
        Member member = memberRepository.findById(1L).orElseThrow();
    }

}