package com.movie.reservation.security.service;

import com.movie.reservation.domain.member.Member;
import com.movie.reservation.domain.member.role.MemberRole;
import com.movie.reservation.repository.MemberRepository;
import com.movie.reservation.security.dto.MemberSecurityRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Member member = memberRepository.findWithRoles(username).orElseThrow(
                () -> new UsernameNotFoundException("username not found : " + username));

        MemberSecurityRequestDto securityLoginDto= new MemberSecurityRequestDto(
                member.getId(),
                member.getUsername(),
                member.getPassword(),
                member.getName(),
                member.getEmail(),
                member.getRoles().stream()
                        .map(memberRole ->
                                new SimpleGrantedAuthority("ROLE_" + memberRole.name()))
                        .collect(Collectors.toList()));

        return securityLoginDto;
    }
}
