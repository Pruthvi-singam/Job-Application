package com.pruthvi.jobMS.Job.Repository;

import com.pruthvi.jobMS.Job.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job,Long> {
}
