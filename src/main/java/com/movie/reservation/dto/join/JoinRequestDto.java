package com.movie.reservation.dto.join;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinRequestDto {

    private String username;
    private String password;
    private String name;
    private String email;
}
