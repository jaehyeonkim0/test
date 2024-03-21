package com.movie.reservation.repository.member;

import com.movie.reservation.domain.member.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUsername(String username);

    @EntityGraph(attributePaths = {"roles"})
    @Query("SELECT M FROM Member M WHERE M.username =:username")
    Optional<Member> findWithRoles(@Param("username") String username);



}
