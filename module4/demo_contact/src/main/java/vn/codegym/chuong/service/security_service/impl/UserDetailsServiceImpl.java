package vn.codegym.chuong.service.security_service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.chuong.model.security_model.MyUserDetails;
import vn.codegym.chuong.model.security_model.User;
import vn.codegym.chuong.service.security_service.UserService;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
//    private UserRepository userRepository;
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username){
        User user = userService.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new MyUserDetails(user);
    }
}
