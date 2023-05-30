package com.lucas.github.financial_planning.config.security.interceptor;

import com.lucas.github.financial_planning.exception.enums.EnumMessagesException;
import com.lucas.github.financial_planning.exception.runtime.DomainRuntimeException;
import com.lucas.github.financial_planning.model.pattern.Constants;
import com.lucas.github.financial_planning.service.JWTUserDetailsService;
import com.lucas.github.financial_planning.utils.TokenUtils;
import com.lucas.github.financial_planning.utils.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InterceptorHandler implements HandlerInterceptor {

    @Autowired
    private JWTUserDetailsService jwtUserDetailsService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String requestTokenHeader = request.getHeader(Constants.HEADER_AUTHORIZATION);

        validateRequest(requestTokenHeader);

        String jwtToken = requestTokenHeader.replace(Constants.BEARER_TOKEN, "");
        String username = getUsernameFromToken(jwtToken);

        if (Utils.isNotEmpty(username) && Utils.isEmpty(SecurityContextHolder.getContext().getAuthentication())) {
            UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);

            if (Boolean.TRUE.equals(TokenUtils.validateToken(jwtToken, userDetails))) {
                authenticate(userDetails, request);
            }
        }
        return true;
    }

    private void authenticate(UserDetails userDetails, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
    }

    private String getUsernameFromToken(final String jwtToken) {
        try {
            return TokenUtils.getUsernameFromToken(jwtToken);
        } catch (Exception e) {
            throw new DomainRuntimeException(EnumMessagesException.MISSING_TOKEN);
        }
    }

    private void validateRequest(String requestTokenHeader) {
        if (Utils.isEmpty(requestTokenHeader) || !requestTokenHeader.startsWith(Constants.BEARER_TOKEN)) {
            throw new DomainRuntimeException(EnumMessagesException.MISSING_TOKEN);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
