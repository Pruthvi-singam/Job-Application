package com.pruthvi.companyMs.Company.Service;

import com.pruthvi.companyMs.Company.Entity.Company;
import com.pruthvi.companyMs.Company.Repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CompanyServiceImp implements CompanyService {
    private CompanyRepository companyRepository;

    public CompanyServiceImp(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> tempCompany =companyRepository.findById(id);
        if(tempCompany.isPresent()) {
            Company tempCompany1 = tempCompany.get();
            tempCompany1.setCompany_name(company.getCompany_name());
            tempCompany1.setDescription(company.getDescription());
//            tempCompany1.setJobs(company.getJobs());
            companyRepository.save(tempCompany1);
            return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);

    }

    @Override
    public boolean deleteCompany(Long id) {
        try
        {
            companyRepository.deleteById(id);
            return true;
        }catch(Exception e)
        {
            return false;
        }
    }

    @Override
    public Company getCompanyById(Long id) {
        if(companyRepository.existsById(id))
        {
            return companyRepository.findById(id).get();
        }
        return null;
    }
}
