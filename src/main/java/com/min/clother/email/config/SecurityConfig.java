package com.min.clother.email.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    //    private final TokenProvider tokenProvider;
    private final CorsFilter corsFilter;
    //    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final UserDetailsService userDetailsService;

    // JwtFilter 를 빈으로 등록
//    @Bean
//    public JwtFilter jwtFilter() {
//        return new JwtFilter(tokenProvider);
//    }

    // PasswordEncoder 빈으로 등록
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // AuthenticationManager 설정
    @Bean
    public AuthenticationManager authenticationManager(
            UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);

        return new ProviderManager(authProvider);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)

                // 🔻 주석 처리: JWT 예외 핸들링
                // .exceptionHandling(exceptionHandling -> exceptionHandling
                //         .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                //         .accessDeniedHandler(jwtAccessDeniedHandler))

                // 🔻 JWT는 무상태, 세션 방식에선 STATELESS 제거
                // .sessionManagement(sessionManagement -> sessionManagement
                //         .sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .headers(headers -> headers
                        .frameOptions(frameOptions -> frameOptions.sameOrigin()))

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/swagger", "/swagger-ui.html", "/swagger-ui/**", "/api-docs", "/api-docs/**",
                                "/v3/api-docs/**", "/auth/**", "/mails/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )

                // 🔻 JWT 필터 제거
                // .addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class)

                // ✅ 세션 로그인 방식 추가
                .formLogin(form -> form
//                        .loginPage("/login")  // 커스텀 로그인 페이지가 없다면 제거해도 됨
                                .permitAll()
                )
                .logout(logout -> logout
                        .permitAll()
                )

                .build();
    }

}
