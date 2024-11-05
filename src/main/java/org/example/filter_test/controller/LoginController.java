package org.example.filter_test.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@Slf4j
public class LoginController {

    @GetMapping("/register")
    public String register(HttpServletRequest req) {
        log.info("register ==> {}", req.getRequestURI());
        return "회원 가입 완료";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest req) {
        log.info("login ==> {}", req.getRequestURI());
        HttpSession session = req.getSession(true);
        session.setAttribute("userId", "aaa");
        return session.getAttribute("userId") + " : 로그인 완료";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest req) {
        log.info("logout ==> {}", req.getRequestURI());
        HttpSession session = req.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        return "로그아웃 완료";
    }
}
