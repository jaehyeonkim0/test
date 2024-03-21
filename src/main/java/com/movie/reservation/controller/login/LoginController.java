package com.movie.reservation.controller.login;

import com.movie.reservation.dto.board.BoardDto;
import com.movie.reservation.dto.mypage.MemberDto;
import com.movie.reservation.security.dto.MemberSecurityRequestDto;
import com.movie.reservation.service.test.TestService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
@RequestMapping("/member/login")
public class LoginController {

    private TestService testService;

    @Autowired
    public LoginController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/login")
    public void loginGET() {}

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/success")
    public void loginSuccess() {
        log.info("진입");
    }

}
