package com.pruthvi.companyMs.Company.Controller;


import com.pruthvi.companyMs.Company.Entity.Company;
import com.pruthvi.companyMs.Company.Service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }



    @GetMapping
    public ResponseEntity<List<Company>> getCompanies() {
        return new ResponseEntity<>(companyService.getAllCompanies() , HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String > updateCompany(@PathVariable Long id,@RequestBody Company company)
    {
        boolean temp=companyService.updateCompany(company,id);
        if(temp)
            return new ResponseEntity<>("successfully updated company",HttpStatus.OK);
        return new ResponseEntity<>("company update failed",HttpStatus.NOT_FOUND);

    }

    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company)
    {
        companyService.createCompany(company);
        return new ResponseEntity<>("successfully created company",HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        boolean temp = companyService.deleteCompany(id);
        if(temp)
            return new ResponseEntity<>("Company deleted successfully",HttpStatus.OK);
        return new ResponseEntity<>("company delete failed",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getById(@PathVariable Long id)
    {
        Company company = companyService.getCompanyById(id);
        if(company!=null)
            return new ResponseEntity<>(company,HttpStatus.OK);
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}
