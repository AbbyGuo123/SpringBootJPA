package com.oocl.springBootSqlTest.OneToN.service;

import com.oocl.springBootSqlTest.OneToN.DTO.CompanyDTO;
import com.oocl.springBootSqlTest.OneToN.DTO.EmployeeDTO;
import com.oocl.springBootSqlTest.OneToN.Enity.Company;
import com.oocl.springBootSqlTest.OneToN.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {


    private CompanyRepository repository;

    @Autowired
    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    public Company saveCompany(Company company){
        company.getEmployees().stream().forEach(employee -> {
            employee.setCompany(company);
        });
        return  repository.save(company);
    }

    public List<Company> getAllCompany(){
        return repository.findAll();
    }

    public CompanyDTO findCompanyById(Long id){
        Company company = repository.findById(id).get();
        return new CompanyDTO(company);
    }

    public List<EmployeeDTO> findEmployeesByCompanyId(Long id){
        Company company = repository.findById(id).get();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        company.getEmployees().stream().forEach(employee ->employeeDTOList.add(new EmployeeDTO(employee)));
        return employeeDTOList;
    }

    public Company updateCompany(Company company){
        return repository.save(company);
    }
    public Company deleteCompany(Long id){
        Company one = repository.findById(id).get();
        repository.delete(one);
        return one;
    }
    public Page<Company> getEmployeesByPage(int page, int size){
        Page<Company> companies = repository.findAll(PageRequest.of(page, size));
        return  companies;
    }
}
