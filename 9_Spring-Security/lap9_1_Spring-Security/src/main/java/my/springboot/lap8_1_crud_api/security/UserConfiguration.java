package my.springboot.lap8_1_crud_api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class UserConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails user1 = User.builder()
                .username("phu")
                .password("{noop}1234567")
                .roles("USER")
                .build();

        UserDetails user2 = User.builder()
                .username("staff")
                .password("{noop}12345678")
                .roles("STAFF")
                .build();

        UserDetails user3 = User.builder()
                .username("admin")
                .password("{noop}123456")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1, user2, user3);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                configurer->configurer
                        .requestMatchers(HttpMethod.GET, "students").hasAnyRole("USER", "STAFF", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "students/**").hasAnyRole("USER", "STAFF", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "students/").hasAnyRole("ADMIN", "STAFF")
                        .requestMatchers(HttpMethod.PUT, "students/**").hasAnyRole("ADMIN", "STAFF")
                        .requestMatchers(HttpMethod.DELETE, "students/**").hasRole("ADMIN")
        );

        http.httpBasic(Customizer.withDefaults());


        return http.build();
    }


}
