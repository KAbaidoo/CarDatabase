package com.kobby.cardatabase.service;

import com.kobby.cardatabase.domain.User;
import com.kobby.cardatabase.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByUsername(username);

        org.springframework.security.core.userdetails.User.UserBuilder userBuilder = null;

        if (user.isPresent()){
            User currentUser = user.get();

            userBuilder = org.springframework.security.core.userdetails.User.withUsername(username);
            userBuilder.password(currentUser.getPassword());
            userBuilder.roles(currentUser.getRole());
        } else {
            throw new UsernameNotFoundException("User not found!");
        }

        return userBuilder.build();
    }
}
