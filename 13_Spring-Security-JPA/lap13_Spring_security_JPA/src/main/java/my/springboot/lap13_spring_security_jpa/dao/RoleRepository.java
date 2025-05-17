package my.springboot.lap13_spring_security_jpa.dao;

import my.springboot.lap13_spring_security_jpa.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findByName(String name);
}
