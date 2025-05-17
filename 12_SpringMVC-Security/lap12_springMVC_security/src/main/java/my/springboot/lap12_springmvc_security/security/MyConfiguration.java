package my.springboot.lap12_springmvc_security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class MyConfiguration {

    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
        jdbcUserDetailsManager.setDataSource(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select id, pw, active from accounts where id = ?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select id, role from roles where id = ?");
        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                configure -> configure
                        .requestMatchers("/public/**").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/staff/**").hasAnyRole("STAFF", "ADMIN")
                        .requestMatchers("/user/**").hasAnyRole("USER", "STAFF", "ADMIN")
        ).formLogin(
                form->form.loginPage("/login")
                        .loginProcessingUrl("/authenticateTheUser")
                        .defaultSuccessUrl("/user", true) // Trang mặc định sau khi login thành công
                        .permitAll()
        ).logout(
                logout -> logout.permitAll()
        ).exceptionHandling(
            configure -> configure.accessDeniedPage("/show-page403")
        );

        return http.build();
    }
}
