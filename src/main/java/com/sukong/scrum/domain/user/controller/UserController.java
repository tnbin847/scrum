package com.sukong.scrum.domain.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>생성된 클래스에 대한 설명을 입력해주세요.</p>
 *
 * @author 박 수 빈
 * @version 1.0
 */

@RestController
public class UserController {

    @GetMapping("/signup")
    public ModelAndView signup() {
        return new ModelAndView("app/user/signup");
    }
}
