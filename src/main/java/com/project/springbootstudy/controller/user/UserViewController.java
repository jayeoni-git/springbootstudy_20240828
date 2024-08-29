package com.project.springbootstudy.controller.user;

import com.project.springbootstudy.domain.user.User;
import com.project.springbootstudy.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserViewController {

    @Autowired
    UserService userService;

    // 로그인 화면 열기
    @GetMapping("/")
    // 나중에 해볼 것 : 로그인으로 들어가도 연결되게 하기!
    public String goLogin() {
        return "user/login";
    }

    // 회원가입 화면 열기
    @GetMapping("/join")
    public String goJoin() {
        return "user/join";
    }

    // 로그인 프로세스(성공 시 홈 화면 열기)
    @PostMapping("login-process")
    public String login(@RequestParam(name="userId") String userId,
                        @RequestParam(name="password") String password,
                        Model model) {
        try {
            userService.userLogin(userId, password); // 로그인 성공하면
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "user/login";
        }

        return "home"; // 홈화면
    }

    // 회원가입 프로세스(성공 시 로그인 화면 열기)
    @PostMapping("join-process")
    public String Join(@ModelAttribute User user, Model model) {
        /*
        0. 입력 받을 데이터 정의 (user 클래스 만들기) (완료)
        1. 사용자 입력 받기 (사용자 입력 받기) (@RequsetParam 이용) (이후에 User 클래스에 담기) (완료)
        2. 적합성 검사 (서비스에서 구현하기) (완료)
        3. DB에 저장 (User 클래스에서 구현하기)
         */


        // 적합성 검사 -> 회원가입 성공 여부 검사
        try {
            userService.userJoin(user);
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "/user/join";
        }
        System.out.println(user.toString());
        return "redirect:/"; // redirect 뒤에는 url을 적어줘야 함!


    }
}