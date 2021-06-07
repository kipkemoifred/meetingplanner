package com.example.meetingOfficePlanner.meetingOfficePlanner.repository;

import com.example.meetingOfficePlanner.meetingOfficePlanner.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer>{
    Optional<User> findByUserName(String userName);
    //Optional<User> findByEmail(String email);
    @Query("UPDATE User u SET u.NumFailedLogins = ?1 WHERE u.userName = ?2")
    @Modifying
    public void updateFailedAttempts(int failAttempts, String userName);

}
