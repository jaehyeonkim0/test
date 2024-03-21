package com.movie.reservation.service.login;

import com.movie.reservation.domain.member.Member;
import com.movie.reservation.domain.member.role.MemberRole;
import com.movie.reservation.repository.member.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Log4j2
class LoginServiceImplTest {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void insertTest() {
        Member member = Member.builder()
                .username("test")
                .password(bCryptPasswordEncoder.encode("123"))
                .name("테스트")
                .email("test@naver.com")
                .build();
        member.addRole(MemberRole.USER);

        memberRepository.save(member);
    }

    @Test
    void getTest() {
        Member memberOptional = memberRepository.findWithRoles("test").orElseThrow();
        memberOptional.addRole(MemberRole.ADMIN);
        memberRepository.save(memberOptional);
    }

    @Test
    @Transactional(readOnly = true) // 지연 조회 시점까지 세션을 유지
    void getMemberTest() {
        Member member = memberRepository.findByUsername("test").orElseThrow();
        for (MemberRole r : member.getRoles()) {
            log.info(r.name());
        }
    }

    @Test
    void getMemberTest1() {
        Member member = memberRepository.findByUsername("test").orElseThrow();
        for (MemberRole r : member.getRoles()) {
            //지연 로딩으로 설정되어있고, @Transactional 어노테이션이 없기 때문에 member의 roles를 가져오지 못한다
            log.info(r.name());
        }
    }

}