package ru.redcube.squadrating.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

//    @Bean
//    public UserDetailsService getUsers() {
//        UserDetails user = User.builder()
//                .username("user")
//                .password("123")
//                .roles("USER")
//                .build();
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("123")
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user, admin);
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/registration", "/login", "/", "/mainPage").permitAll()
                .requestMatchers("/users", "/works/**", "/userToWorks/**", "/squadWorks/**")
                .hasAnyAuthority("BASIC_STATE")
                .requestMatchers("/create/**").hasAuthority("CREATOR")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .permitAll();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // todo Шифрование для паролей сделять
        return NoOpPasswordEncoder.getInstance();
    }

}
