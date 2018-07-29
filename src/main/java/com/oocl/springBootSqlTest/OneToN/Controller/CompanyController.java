package com.oocl.springBootSqlTest.OneToN.Controller;

import com.oocl.springBootSqlTest.OneToN.DTO.CompanyDTO;
import com.oocl.springBootSqlTest.OneToN.DTO.EmployeeDTO;
import com.oocl.springBootSqlTest.OneToN.Enity.Company;
import com.oocl.springBootSqlTest.OneToN.Repository.CompanyRepository;
import com.oocl.springBootSqlTest.OneToN.service.CompanyService;
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


    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Transactional
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Company save(@RequestBody Company company) {
        return companyService.saveCompany(company);
    }

    @Transactional
    @GetMapping(path = "")
    public List<Company> getAllCompany(){
        return companyService.getAllCompany();
    }

    @Transactional
    @GetMapping(path = "/{id}")
    public CompanyDTO findCompanyById(@PathVariable Long id){
        return companyService.findCompanyById(id);
    }

    @Transactional
    @GetMapping(path = "/{id}/employees")
    public List<EmployeeDTO> findEmployeesByCompanyId(@PathVariable Long id)throws Exception{
        return companyService.findEmployeesByCompanyId(id);
    }

    @Transactional
    @PutMapping
    public Company update(@RequestBody Company company){
        return companyService.updateCompany(company);
    }

    @Transactional
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Company delete(@PathVariable("id")Long id) {
        return companyService.deleteCompany(id);
    }

    @Transactional
    @GetMapping(path = "/page")
    public Page<Company> getEmployeesByPage(int page, int size){
        return  companyService.getEmployeesByPage(page,size);
    }

}
