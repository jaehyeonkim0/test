package com.movie.reservation.controller.mypage;

import com.movie.reservation.service.mypage.MyPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member/mypage")
public class MyPageController {

    private final MyPageService myPageService;


    @GetMapping("/mypage")
    public void mypageGET() {
        System.out.println("Git Fetch 테스트중입니다2");
    }
}
