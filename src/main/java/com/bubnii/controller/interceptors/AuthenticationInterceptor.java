package com.bubnii.controller.interceptors;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    private HttpServletRequest httpRequest;
    private HttpServletResponse httpResponse;

    private String[] loginRequiredUrls = {"/profile", "/booking"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        httpRequest = request;
        httpResponse = response;

        HttpSession session = httpRequest.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("user") != null);

        String loginUri = httpRequest.getContextPath() + "/login";
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginUri);
        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login.jsp");


        if (isLoggedIn && (isLoginRequest || isLoginPage)) {
            // the user is already logged in and he's trying to login again
            // then forward to the homepage
            httpResponse.sendRedirect("/");
            return false;
        } else if (!isLoggedIn && isLoginRequired()) {
            // the user is not logged in, and the requested page requires
            // authentication, then forward to the login page
            httpResponse.sendRedirect("login");
            return false;
        } else {
            // for other requested pages that do not require authentication
            // or the user is already logged in, continue to the destination
            return true;
        }
    }

    private boolean isLoginRequired() {

        String requestUrl = httpRequest.getRequestURL().toString();

        for (String loginRequiredUrl : loginRequiredUrls) {
            if (requestUrl.contains(loginRequiredUrl)) {
                return true;
            }
        }

        return false;
    }

}
