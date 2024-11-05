package org.example.filter_test.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.filter_test.domain.User;
import org.example.filter_test.service.LoginService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/register")
    public String register(HttpServletRequest req) {
//        log.info("register ==> {}", req.getRequestURI());
        return "회원 가입 완료";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest req,
                        HttpServletResponse resp,
                        @RequestBody User user) {
//        log.info("login ==> {}", req.getRequestURI());
        boolean isLogin = loginService.isLoginSuceess(user);
        if(isLogin) {
            HttpSession session = req.getSession(true);
            String uuid = UUID.randomUUID().toString();
            session.setAttribute("session_id", uuid);
            session.setAttribute("userId", user.getUserId());
            session.setMaxInactiveInterval(60);
            Cookie cookie = new Cookie("session_id", uuid);
            resp.addCookie(cookie);
            return "로그인 성공";
        }
        return "로그인 실패";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest req) {
//        log.info("logout ==> {}", req.getRequestURI());
        HttpSession session = req.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        return "로그아웃 완료";
    }
}
