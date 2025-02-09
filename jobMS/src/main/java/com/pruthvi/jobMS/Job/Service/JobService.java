package com.pruthvi.jobMS.Job.Service;



import com.pruthvi.jobMS.Job.Entity.Job;
import com.pruthvi.jobMS.Job.dto.JobDTO;

import java.util.List;

public interface JobService {
    public List<JobDTO> findAllJobs();
    public void createJob(Job job);
    public JobDTO findJobById(Long id);
    public boolean deleteJobById(Long id);
    public boolean updateJob(Long id,Job job);
}
