package my.springboot.lap13_spring_security_jpa.dao;

import my.springboot.lap13_spring_security_jpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);
}
