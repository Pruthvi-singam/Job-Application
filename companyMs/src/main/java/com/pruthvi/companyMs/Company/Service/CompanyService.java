package com.pruthvi.companyMs.Company.Service;


import com.pruthvi.companyMs.Company.Entity.Company;

import java.util.List;


public interface CompanyService {
    public List<Company> getAllCompanies();
    boolean updateCompany(Company company,Long id);
    void createCompany(Company company);
    boolean deleteCompany(Long id);
    public Company getCompanyById(Long id);

}
