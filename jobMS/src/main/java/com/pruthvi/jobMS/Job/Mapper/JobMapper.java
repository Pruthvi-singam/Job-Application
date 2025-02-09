package com.pruthvi.jobMS.Job.Mapper;

import com.pruthvi.jobMS.Job.Entity.Job;
import com.pruthvi.jobMS.Job.dto.JobDTO;
import com.pruthvi.jobMS.Job.external.Company;
import com.pruthvi.jobMS.Job.external.Review;

import java.util.List;

public class JobMapper {
    public static JobDTO mapToJobWithCompanyDTO(Job job, Company company, List<Review> reviews) {
        JobDTO jobDTO = new JobDTO();
        jobDTO.setId(job.getId());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setMaxSalary(job.getMaxSalary());
        jobDTO.setMinSalary(job.getMinSalary());
        jobDTO.setCompany(company);
        jobDTO.setReviews(reviews);

        return jobDTO;
    }
}
