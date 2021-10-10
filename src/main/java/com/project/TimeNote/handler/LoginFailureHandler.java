package com.project.TimeNote.handler;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException accessException)
            throws IOException, ServletException {

        if (accessException instanceof AuthenticationServiceException) {
            request.setAttribute("LoginFailMessage", "존재하지 않는 사용자입니다.");

        } else if (accessException instanceof BadCredentialsException) {
            request.setAttribute("LoginFailMessage", "비밀번호가 틀립니다.");

        }

        // 로그인 페이지로 다시 포워딩
        RequestDispatcher dispatcher = request.getRequestDispatcher("/auth/loginForm");
        dispatcher.forward(request, response);

    }
}

