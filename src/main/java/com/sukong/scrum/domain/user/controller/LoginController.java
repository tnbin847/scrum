package com.sukong.scrum.domain.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>생성된 클래스에 대한 설명을 입력해주세요.</p>
 *
 * @author 박 수 빈
 * @version 1.0
 */

@Controller
public class LoginController {

    @GetMapping("/")
    public String login() {
        return "app/index";
    }
}
