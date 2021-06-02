package com.example.meetingOfficePlanner.meetingOfficePlanner;

import com.example.meetingOfficePlanner.meetingOfficePlanner.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@SpringBootApplication
public class MeetingOfficePlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeetingOfficePlannerApplication.class, args);
	}
	//System.out.print("");

}
