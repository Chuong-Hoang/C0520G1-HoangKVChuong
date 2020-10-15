package vn.codegym.furama.data_seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import vn.codegym.furama.model.security_model.Role;
import vn.codegym.furama.model.security_model.User;
import vn.codegym.furama.repository.main_repo.RoleRepository;
import vn.codegym.furama.repository.main_repo.UserRepository;


import java.util.HashSet;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // Roles
        if(roleRepository.findByRoleName("ROLE_ADMIN") == null){
            roleRepository.save(new Role("ROLE_ADMIN"));
        }

        if(roleRepository.findByRoleName("ROLE_MEMBER") == null){
            roleRepository.save(new Role("ROLE_MEMBER"));
        }

        // Admin account
        if(userRepository.findByUserName("admin") == null){
            User admin = new User();
            admin.setUserName("admin");
            admin.setPassword(passwordEncoder.encode("12345"));

            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByRoleName("ROLE_ADMIN"));
            roles.add(roleRepository.findByRoleName("ROLE_MEMBER"));
            admin.setRoles(roles);

            userRepository.save(admin);
        }

        // Member account
        if(userRepository.findByUserName("member") == null){
            User user = new User();
            user.setUserName("member");
            user.setPassword(passwordEncoder.encode("12345"));

            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByRoleName("ROLE_MEMBER"));
            user.setRoles(roles);

            userRepository.save(user);
        }
    }
}
