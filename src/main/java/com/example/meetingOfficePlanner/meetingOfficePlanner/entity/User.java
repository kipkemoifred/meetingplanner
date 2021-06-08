package com.example.meetingOfficePlanner.meetingOfficePlanner.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "User")
@EntityListeners(AuditingEntityListener.class)
public class User extends Auditable<String> {
    @Id
    @GeneratedValue
    int userId;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getNumFailedLogins() {
        return NumFailedLogins;
    }

    public void setNumFailedLogins(int numFailedLogins) {
        NumFailedLogins = numFailedLogins;
    }

    public int getTimesUsedSamePassword() {
        return timesUsedSamePassword;
    }

    public void setTimesUsedSamePassword(int timesUsedSamePassword) {
        this.timesUsedSamePassword = timesUsedSamePassword;
    }

    public LocalTime getLockedUntil() {
        return LockedUntil;
    }

    public void setLockedUntil(LocalTime lockedUntil) {
        LockedUntil = lockedUntil;
    }

    private String password;
    private String roles;
    private boolean active;
    private int NumFailedLogins;//max 4 30 mins
    private int timesUsedSamePassword;//4 change psd
    private LocalTime LockedUntil;
    private String StakeholderPosition;
    private String email;
    private String phoneNumber;


    public void setRoles(String roles) {
        this.roles = roles;
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

    public User() {
        super();
    }

    public User(String userName, String password, String roles, boolean active, int numFailedLogins, int timesUsedSamePassword, LocalTime lockedUntil, String stakeholderPosition, String email, String phoneNumber) {
        this.userName = userName;
        this.password = password;
        this.roles = roles;
        this.active = active;
        this.NumFailedLogins = numFailedLogins;
        this.timesUsedSamePassword = timesUsedSamePassword;
        this.LockedUntil = lockedUntil;
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

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                ", active=" + active +
                ", NumFailedLogins=" + NumFailedLogins +
                ", timesUsedSamePassword=" + timesUsedSamePassword +
                ", LockedUntil=" + LockedUntil +
                ", StakeholderPosition='" + StakeholderPosition + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
