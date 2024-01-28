package com.ecommerce.onlinestore.config;

import com.ecommerce.onlinestore.config.jwt.JwtAuthenticationEntryPoint;
import com.ecommerce.onlinestore.config.jwt.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationEntryPoint point;
    @Autowired
    private JwtAuthenticationFilter filter;

    @Bean
    public AuthenticationManager authenticationManager(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userDetailsService);
        return new ProviderManager(provider);
    }
/*.requestMatchers("/auth/login").permitAll()*/
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

       /* http.csrf(csrf -> csrf.disable())
                .authorizeRequests().
                requestMatchers("/test").authenticated().requestMatchers("/auth/login").permitAll()
                .anyRequest()
                .authenticated()
                .and().exceptionHandling(ex -> ex.authenticationEntryPoint(point))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);*/

             http.authorizeHttpRequests(authz -> authz.requestMatchers( "/registration**",
                                "/auth/login",
                        "/forgot**",
                        "/sendOtp**",
                        "/js/**",
                        "/css/**",
                        "/cart",
                        "/img/**").permitAll().anyRequest().authenticated()).formLogin(s->s.loginPage("/login").permitAll())
                     .csrf(AbstractHttpConfigurer::disable)
                        .logout(d ->d.logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout").permitAll())
                        .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
                .sessionManagement(sm ->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
                http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();

               /* .csrf().disable().
                authorizeHttpRequests().antMatchers(
                        "/registration**",
                        "/forgot**",
                        "/sendOtp**",
                        "/js/**",
                        "/css/**",
                        "/cart",
                        "/img/**").permitAll().anyRequest().authenticated()
                .and().formLogin().loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();
        return http.build();*/
    }


}
