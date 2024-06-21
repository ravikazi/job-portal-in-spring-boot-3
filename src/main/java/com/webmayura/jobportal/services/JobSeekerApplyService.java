package com.webmayura.jobportal.services;

import com.webmayura.jobportal.entity.JobPostActivity;
import com.webmayura.jobportal.entity.JobSeekerApply;
import com.webmayura.jobportal.entity.JobSeekerProfile;
import com.webmayura.jobportal.repository.JobSeekerApplyRepository;
import com.webmayura.jobportal.repository.JobSeekerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerApplyService {
    private final JobSeekerApplyRepository jobSeekerApplyRepository;

    @Autowired
    public JobSeekerApplyService(JobSeekerApplyRepository jobSeekerApplyRepository) {
        this.jobSeekerApplyRepository = jobSeekerApplyRepository;
    }

    public List<JobSeekerApply> getCandidatesJobs(JobSeekerProfile userAccountId){
        return jobSeekerApplyRepository.findByUserId(userAccountId);
    }

    public List<JobSeekerApply> getJobsCandidates(JobPostActivity job){
        return jobSeekerApplyRepository.findByJob(job);
    }


    public void addNew(JobSeekerApply jobSeekerApply) {
        jobSeekerApplyRepository.save(jobSeekerApply);
    }
}
