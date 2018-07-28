package com.oocl.springBootSqlTest.OneToN.Controller;

import com.oocl.springBootSqlTest.OneToN.DTO.CompanyDTO;
import com.oocl.springBootSqlTest.OneToN.DTO.EmployeeDTO;
import com.oocl.springBootSqlTest.OneToN.Enity.Company;
import com.oocl.springBootSqlTest.OneToN.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private CompanyRepository repository;

    public CompanyController(CompanyRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Company save(@RequestBody Company company) {
        company.getEmployees().stream().forEach(employee -> {
            employee.setCompany(company);
        });
        return  repository.save(company);
    }

    @Transactional
    @GetMapping(path = "")
    public List<Company> getAllCompany(){
        return repository.findAll();
    }

    @Transactional
    @GetMapping(path = "/{id}")
    public CompanyDTO findCompanyById(@PathVariable Long id){
        Company company = repository.findById(id).get();
        return new CompanyDTO(company);
    }

    @Transactional
    @GetMapping(path = "/{id}/employees")
    public List<EmployeeDTO> findEmployeesByCompanyId(@PathVariable Long id)throws Exception{
        Company company = repository.findById(id).get();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        company.getEmployees().stream().forEach(employee ->employeeDTOList.add(new EmployeeDTO(employee)));
        return employeeDTOList;
    }

    @Transactional
    @PutMapping
    public Company update(@RequestBody Company company){
        return repository.save(company);
    }

    @Transactional
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Company delete(@PathVariable("id")Long id) {
        Company one = repository.findById(id).get();
        repository.delete(one);
        return one;
    }

    @Transactional
    @GetMapping(path = "/page")
    public Page<Company> getEmployeesByPage(int page, int size){
        Pageable pageable =new PageRequest(page, size);
        Page<Company> companies = repository.findAll(pageable);
        return  companies;
    }

}
