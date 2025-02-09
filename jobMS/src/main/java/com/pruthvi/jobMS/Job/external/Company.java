package com.pruthvi.jobMS.Job.external;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Company {

    private Long id;
    private String Company_name;
    private String description;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany_name() {
        return Company_name;
    }

    public void setCompany_name(String company_name) {
        Company_name = company_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
