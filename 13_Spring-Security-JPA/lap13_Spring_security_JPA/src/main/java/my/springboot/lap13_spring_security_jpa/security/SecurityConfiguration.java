package my.springboot.lap13_spring_security_jpa.security;

import my.springboot.lap13_spring_security_jpa.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(UserService userService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userService);
        provider.setPasswordEncoder(bCryptPasswordEncoder());
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http , UserService userService) throws Exception {
        http
                .authenticationProvider(daoAuthenticationProvider(userService))
                .authorizeHttpRequests(
                configure -> configure.anyRequest().authenticated()
        ).formLogin(
                form->form.loginPage("/login")
                        .loginProcessingUrl("authenticateTheUser")
                        .defaultSuccessUrl("/home", true) // Trang mặc định sau khi login thành công
                        .permitAll()
        ).logout(
                logout -> logout.permitAll()
        ).exceptionHandling(
                configure -> configure.accessDeniedPage("/403")
        );
        return http.build();
    }


}
