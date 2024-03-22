package com.movie.reservation.controller.mypage;

import com.movie.reservation.config.session.SessionConstant;
import com.movie.reservation.dto.mypage.MemberDto;
import com.movie.reservation.service.mypage.MyPageService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member/mypage")
public class MyPageController {

    private final MyPageService myPageService;

    @GetMapping("/mypage")
    public String mypageGET(Authentication authentication, Model model) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();

        MemberDto memberDto = myPageService.getMemberDto(username);
        model.addAttribute("member", memberDto);

        return "member/mypage/mypage";
    }
}
