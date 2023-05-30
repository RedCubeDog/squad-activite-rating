package ru.redcube.squadrating.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Конфигурация для Spring Security
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    /**
     * Фильтры для запросов.
     * Тут указывается к чему и с какой ролью имеет доступ пользователь
     *
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/registration", "/login", "/")
                .permitAll()
                .requestMatchers("/mainPage", "/squadWorks", "/userToWorks")
                .hasAnyAuthority("ROLE_BASIC_STATE", "ROLE_ADMINISTRATION_STATE")
                .requestMatchers("/**")
                .hasAnyAuthority("ROLE_ADMINISTRATION_STATE")
//                .requestMatchers("/userToWorks/**", "/squadWorks/**")
//                .hasAnyAuthority("ROLE_ADMINISTRATION_STATE")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .permitAll();
        return http.build();
    }

    /**
     * Тут указывается тип шифрования пароля пользователей
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(); // todo зашифровать
        return NoOpPasswordEncoder.getInstance();
    }
}
