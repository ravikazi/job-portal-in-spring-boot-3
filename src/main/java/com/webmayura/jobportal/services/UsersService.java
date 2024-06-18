package com.webmayura.jobportal.services;

import com.webmayura.jobportal.entity.JobSeekerProfile;
import com.webmayura.jobportal.entity.RecruiterProfile;
import com.webmayura.jobportal.entity.Users;
import com.webmayura.jobportal.repository.JobSeekerProfileRepository;
import com.webmayura.jobportal.repository.RecruiterProfileRepository;
import com.webmayura.jobportal.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository,RecruiterProfileRepository recruiterProfileRepository,JobSeekerProfileRepository jobSeekerProfileRepository) {
        this.usersRepository = usersRepository;
        this.recruiterProfileRepository = recruiterProfileRepository;
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
    }

    public Users addNewUser(Users users){
        users.setActive(true);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));
        Users savedUser = usersRepository.save(users);
        int userTypeId= users.getUserTypeId().getUserTypeId();
        if (userTypeId==1){
            recruiterProfileRepository.save(new RecruiterProfile(savedUser));
        }else{
            jobSeekerProfileRepository.save(new JobSeekerProfile(savedUser));
        }
        return savedUser;
    }
}
