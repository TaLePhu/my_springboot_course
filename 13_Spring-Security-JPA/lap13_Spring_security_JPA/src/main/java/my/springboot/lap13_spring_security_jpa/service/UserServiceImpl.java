package my.springboot.lap13_spring_security_jpa.service;

import jakarta.annotation.PostConstruct;
import my.springboot.lap13_spring_security_jpa.dao.RoleRepository;
import my.springboot.lap13_spring_security_jpa.dao.UserRepository;
import my.springboot.lap13_spring_security_jpa.entities.Role;
import my.springboot.lap13_spring_security_jpa.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void insertUser() {
        User user1 = new User();
        user1.setUsername("admin");
        user1.setPassword("$2a$12$0q0U0ZkbEwOS69yZ6y0L8e/mRcDjL167DvmZbAjpTNAP4o3X/4qre");
        user1.setEnabled(true);

        Role role1 = new Role();
        role1.setName("ROLE_ADMIN");

        Collection<Role> roles = new ArrayList<>();
        roles.add(role1);
        user1.setRoles(roles);

        userRepository.save(user1);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), rolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> rolesToAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
