package com.duong.store.service;

import com.duong.store.models.AppUer;
import com.duong.store.respository.AppUserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {
    @Autowired
    private AppUserRespository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        AppUer appUer = repo.findByEmail(email);

        if (appUer!= null){
            var springUser = User.withUsername(appUer.getEmail())
                    .password(appUer.getPassword())
                    .roles(appUer.getRole())
                    .build();
            return springUser;
        }
        return null;
    }
}
