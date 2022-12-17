package com.example.ecommerce.configs;

import com.example.ecommerce.utils.CustomAccessDenied;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.ecommerce.services.UserService;
import com.example.ecommerce.utils.CustomSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {
    @Autowired
    private UserService userService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler customSuccessHandler() {
        return new CustomSuccessHandler();
    }

    @Bean
    public AccessDeniedHandler customAccessDenied() {
        return new CustomAccessDenied();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers("/products", "/404", "/product/**").permitAll()
                                .requestMatchers("/css/**", "/", "/js/**", "/font-awesome/**", "/ico/**", "/js/**",
                                        "/img/**")
                                .permitAll()
                                .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                                .requestMatchers("/login").anonymous()
                                .requestMatchers("/register").anonymous()
                                .anyRequest().authenticated())
                .userDetailsService(userService)
                // .httpBasic(Customizer.withDefaults())
                .formLogin(
                        form -> form.loginPage("/login")
                                .usernameParameter("tel")
                                .loginProcessingUrl("/login")
                                .successHandler(customSuccessHandler())
                                .failureHandler(
                                        (request, response, exception) -> System.out.println(exception.toString())))
                .exceptionHandling() // access denied handling
                .accessDeniedHandler(customAccessDenied()).and()
                .logout(logout -> logout
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login")
                        .permitAll())
                .build();
    }
}