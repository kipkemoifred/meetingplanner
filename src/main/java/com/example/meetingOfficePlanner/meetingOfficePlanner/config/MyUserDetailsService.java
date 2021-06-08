package com.example.meetingOfficePlanner.meetingOfficePlanner.config;

//import com.example.meetingOfficePlanner.meetingOfficePlanner.entity.User;

import com.example.meetingOfficePlanner.meetingOfficePlanner.entity.User;
import com.example.meetingOfficePlanner.meetingOfficePlanner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

//import org.springframework.security.core.userdetails.User;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(username);
        user.orElseThrow(() -> new UsernameNotFoundException("not found" + username));
        return user.map(MyUserDetails::new).get();
        //return new User("foo","foo",new ArrayList<>());
    }
}
