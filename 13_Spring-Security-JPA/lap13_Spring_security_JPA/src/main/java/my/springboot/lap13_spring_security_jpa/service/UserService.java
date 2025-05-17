package my.springboot.lap13_spring_security_jpa.service;

import my.springboot.lap13_spring_security_jpa.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User findByUsername(String username);
}
