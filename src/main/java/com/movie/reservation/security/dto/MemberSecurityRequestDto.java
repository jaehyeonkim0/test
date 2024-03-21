package com.movie.reservation.security.dto;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@Setter
public class MemberSecurityRequestDto extends User {

    private Long id;
    private String username;
    private String password;
    private String name;
    private String email;

    public MemberSecurityRequestDto(Long id,
                                    String username,
                                    String password,
                                    String name,
                                    String email,
                                    Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);

        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
    }

}
