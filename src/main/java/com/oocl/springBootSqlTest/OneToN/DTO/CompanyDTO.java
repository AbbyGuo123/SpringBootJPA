package com.oocl.springBootSqlTest.OneToN.DTO;

import com.oocl.springBootSqlTest.OneToN.Enity.Company;
import com.oocl.springBootSqlTest.OneToN.Enity.Employee;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyDTO {

    private long id;
    private String companyName;
    private ZonedDateTime createDate;
    private List<EmployeeDTO> employees;

    public long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public CompanyDTO(Company company) {
        this.id = company.getId();
        this.companyName = company.getCompanyName();
        this.createDate = company.getCreateDate();
        this.employees = company.getEmployees().stream().map(employee -> new EmployeeDTO(employee)).collect(Collectors.toList());

    }
}
