package com.lucas.github.financial_planning.config.security;

import com.lucas.github.financial_planning.config.security.provider.AuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
public class WebSecurityConfig {

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Value("${api.no-secured-urls}")
    private List<String> noSecuredUrl;

    @Value("${api.base-path}")
    private String basePath;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests()
                .requestMatchers("/")
                .permitAll()
                .requestMatchers(basePath)
                .authenticated()
                .and()
                .requiresChannel()
                .requestMatchers(r -> r.getHeader("X-Forwarded-Proto") != null)
                .requiresSecure()
                .and()
                .formLogin()
                .disable()
                .httpBasic()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .build();
    }

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth, UserDetailsService detailsService) {
        auth.authenticationProvider(new AuthenticationProvider(detailsService).passwordEncoder(passwordEncoder));
    }



}
