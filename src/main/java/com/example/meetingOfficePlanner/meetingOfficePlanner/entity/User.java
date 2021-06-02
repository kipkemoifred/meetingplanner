package com.example.meetingOfficePlanner.meetingOfficePlanner.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    int userId;
    private String username;
    private String password;

    public void setRoles(String roles) {
        this.roles = roles;
    }

    private String roles;
    private boolean active;
    private String StakeholderPosition;
    private String email;
    private String phoneNumber;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                ", active=" + active +
                ", StakeholderPosition='" + StakeholderPosition + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public String getRoles() {
        return roles;
    }

    public void setRole(String roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public User(){
        super();
    }

    public User(String username, String password, String roles, boolean active, String stakeholderPosition, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.active = active;
        this.StakeholderPosition = stakeholderPosition;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStakeholderPosition() {
        return StakeholderPosition;
    }

    public void setStakeholderPosition(String stakeholderPosition) {
        StakeholderPosition = stakeholderPosition;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
