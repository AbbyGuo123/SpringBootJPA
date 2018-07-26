package com.oocl.springBootSqlTest.OneToN;

import com.oocl.springBootSqlTest.OneToN.Enity.Company;
import com.oocl.springBootSqlTest.OneToN.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private CompanyRepository repository;

    public CompanyController(CompanyRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @PostMapping(path = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public void addCompany(@RequestBody Company company){
        System.out.println("aaaaaaa"+company.getCompanyName());
        repository.save(company);
    }

    @Transactional
    @GetMapping(path = "")
    public List<Company> getAllCompany(){
        return repository.findAll();
    }

    @Transactional
    @GetMapping(path = "/{id}")
    public Company findCompanyById(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @Transactional
    @PutMapping
    public Company update(@RequestBody Company company){
        return repository.save(company);
    }

}
