package com.webmayura.jobportal.services;

import com.webmayura.jobportal.entity.Users;
import com.webmayura.jobportal.repository.UsersRepository;
import com.webmayura.jobportal.util.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UsersRepository usersRepository;

    @Autowired
    public CustomUserDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*Tell Spring security how to retrieve the users from Database*/
        Users user = usersRepository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("Could not find user."));
        return new CustomUserDetails(user);
    }
}
