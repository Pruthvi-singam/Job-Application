package com.pruthvi.companyMs.Company.Repository;

import com.pruthvi.companyMs.Company.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompanyRepository extends JpaRepository<Company,Long> {
}
