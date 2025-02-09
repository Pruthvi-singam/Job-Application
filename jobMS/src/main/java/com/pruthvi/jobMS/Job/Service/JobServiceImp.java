package com.pruthvi.jobMS.Job.Service;

import com.pruthvi.jobMS.Job.Clients.CompanyClient;
import com.pruthvi.jobMS.Job.Clients.ReviewClient;
import com.pruthvi.jobMS.Job.Entity.Job;
import com.pruthvi.jobMS.Job.Mapper.JobMapper;
import com.pruthvi.jobMS.Job.Repository.JobRepository;
import com.pruthvi.jobMS.Job.dto.JobDTO;
import com.pruthvi.jobMS.Job.external.Company;
import com.pruthvi.jobMS.Job.external.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class JobServiceImp implements JobService{
    JobRepository jobRepository;
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private CompanyClient companyClient;
    private ReviewClient reviewClient;


    public JobServiceImp(JobRepository jobRepository,CompanyClient companyClient,ReviewClient reviewClient) {
        this.jobRepository = jobRepository;
        this.companyClient=companyClient;
        this.reviewClient=reviewClient;
    }

    private JobDTO getJobWithCompanyDTO(Job job)
    {
        Company company = companyClient.getCompany(job.getCompanyId());
        List<Review> reviews=reviewClient.getReviews(job.getCompanyId());
        JobDTO jobDTO = JobMapper.mapToJobWithCompanyDTO(job, company, reviews);
        return jobDTO;
    }


    @Override
    public List<JobDTO> findAllJobs() {
        List<Job> jobs=jobRepository.findAll();
        List<JobDTO> jobDTOS =new ArrayList<>();

        return jobs.stream().map(this::getJobWithCompanyDTO).collect(Collectors.toList());
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);

    }

    @Override
    public JobDTO findJobById(Long id) {

        Job job= jobRepository.findById(id).orElse(null);
        return getJobWithCompanyDTO(job);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try{
            jobRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }

    }

    @Override
    public boolean updateJob(Long id,Job job) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent())
        {
            Job job1=jobOptional.get();
            job1.setDescription(job.getDescription());
            job1.setMinSalary(job.getMinSalary());
            job1.setMaxSalary(job.getMaxSalary());
            job1.setLocation(job.getLocation());
            jobRepository.save(job1);
            return true;
        }
        return false;

    }
}
