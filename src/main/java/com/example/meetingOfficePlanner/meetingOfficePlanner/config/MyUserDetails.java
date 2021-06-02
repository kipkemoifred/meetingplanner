package com.example.meetingOfficePlanner.meetingOfficePlanner.config;

import com.example.meetingOfficePlanner.meetingOfficePlanner.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {
    private String userName;
    private String password;
    private String roles;
    private boolean active;
    private String stakeholderPosition;
    private String email;
    private String phoneNumber;
    private List<GrantedAuthority> authorities;

    public MyUserDetails(User user){
this.userName=user.getUsername();
this.password=user.getPassword();
this.active=user.isActive();
this.stakeholderPosition=user.getStakeholderPosition();
this.email=user.getEmail();
this.phoneNumber=user.getPhoneNumber();
this.authorities= Arrays.stream(user.getRoles().split(","))
.map(SimpleGrantedAuthority::new)
.collect(Collectors.toList())
;
    }

MyUserDetails(){}
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;//locked for 30 mins for incorrect credentials
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;//expires in 4 days
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
