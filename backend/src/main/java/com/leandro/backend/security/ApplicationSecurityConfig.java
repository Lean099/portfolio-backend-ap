package com.leandro.backend.security;

import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import com.leandro.backend.filter.CustomAuthenticationFilter;
import com.leandro.backend.filter.CustomAuthorizationFilter;
import com.leandro.backend.security.MyCustomDsl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class ApplicationSecurityConfig{
    
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordConfig passwordEncoder;  // revisar esto, podria usar el PasswordConfig
    //private PasswordEncoder passwordEnconder;
    //@Autowired
    //private ApplicationContext applicationContext;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception{
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder.passwordEncoder())
                .and()
                .build();                                                
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .cors().configurationSource(request -> {
                var cors = new CorsConfiguration();
                cors.setAllowedOrigins(List.of("http://localhost:3000", "http://127.0.0.1:3000", "http://127.0.0.1:8080", "*"));
                cors.setAllowedMethods(List.of("GET","POST", "PUT", "DELETE", "OPTIONS"));
                cors.setAllowedHeaders(List.of("*"));
                return cors;
            })
            .and()
            .authorizeRequests()
            .antMatchers("/login").permitAll()
            .antMatchers("/api/user/create").permitAll()
            .antMatchers("/api/**").authenticated()
            .anyRequest().authenticated()
            .and()
            .apply(MyCustomDsl.customDsl());
            
            //.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
            
            return http.build();
    }

}
