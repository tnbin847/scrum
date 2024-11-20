package com.sukong.scrum.global.config.security;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 스프링 시큐리티 설정 클래스
 *
 * @author 박 수 빈
 * @version 1.0.0
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 사용자에 대한 인증을 요구하지 않고 액세스를 허용할 요청 URL
     */
    private static final String[] PUBLICY_URL_MATCHERS = {
            "/",
            "/sign-up",
            "/api/v1/auth/login",
            "/api/v1/auth/logout",
            "/api/v1/user",
            "/api/v1/user/exists/**"
    };

    /**
     * 비밀번호 암호화 객체 스프링 빈 등록
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 보안 필터를 적용할 필요가 없는 정적 웹 리소스 설정
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .requestMatchers(PathRequest.toH2Console())
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    /**
     * 요청에 대한 세부적인 보안 기능 설정
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .headers().frameOptions().sameOrigin()
        .and().authorizeRequests()
            .antMatchers(PUBLICY_URL_MATCHERS).permitAll()
            .anyRequest().authenticated()
        .and().formLogin()
            .usernameParameter("id")
            .passwordParameter("password")
        .and().sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            .maximumSessions(1)
            .maxSessionsPreventsLogin(true);
    }
}