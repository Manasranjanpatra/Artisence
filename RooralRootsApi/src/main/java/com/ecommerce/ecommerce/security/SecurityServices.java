package com.ecommerce.ecommerce.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ecommerce.ecommerce.users.Entity.User;
import com.ecommerce.ecommerce.users.Repository.UserRepo;




@Component
public class SecurityServices implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User myuser = userRepo.findByPhone(username);

        if (myuser != null) {
            UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                    .username(myuser.getPhone())
                    .password(myuser.getPassword())
                    .roles(myuser.getRole())
                    .build();
            return userDetails;
        }
        throw new UsernameNotFoundException("user not found " + username);

    }

}
