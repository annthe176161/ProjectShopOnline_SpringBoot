package org.shoponline.shoponline.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            Boolean isLoggedIn = (Boolean) request.getSession().getAttribute("isLoggedIn");
            if (isLoggedIn == null) {
                isLoggedIn = false;
            }
            modelAndView.addObject("isLoggedIn", isLoggedIn);
        }
    }
}