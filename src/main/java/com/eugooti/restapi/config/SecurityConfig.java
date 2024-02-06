package com.eugooti.restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager () {
        UserDetails user = User.builder()
                .username("user")
                .password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("{bcrypt}Password")
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }


//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails user = User.withUsername("User")
//                .password("{noop}Password")
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.withUsername("Admin")
//                .password("{noop}Password")
//                .roles("ADMIN")
//                .build();
//
//        return new  InMemoryUserDetailsManager(user,admin);
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth->{
                    auth.requestMatchers("/").permitAll();
                    auth.requestMatchers("/api/todo/*").permitAll();
                    auth.requestMatchers("/api/expenditure/*").permitAll();
                    auth.requestMatchers("/api/category/*").permitAll();
                    auth.requestMatchers("/api/events/*").permitAll();
                    auth.requestMatchers("/api/users/*").hasRole("ADMIN");
                })
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(withDefaults())
                .build();
    }


//    @Configuration
//    @EnableWebSecurity
//    public class SecurityConfig {
//
//        @Bean
//        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//            http
//                    .authorizeHttpRequests(authorize -> authorize
//                            .requestMatchers("/blog/**").permitAll()
//                            .anyRequest().authenticated()
//                    )
//                    .formLogin(formLogin -> formLogin
//                            .loginPage("/login")
//                            .permitAll()
//                    )
//                    .rememberMe(Customizer.withDefaults());
//
//            return http.build();
//        }
//    }


    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
