package com.oocl.springBootSqlTest.OneToN.service;

import com.oocl.springBootSqlTest.OneToN.Enity.Employee;
import com.oocl.springBootSqlTest.OneToN.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {


    private EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployee (){
        return repository.findAll();
    }

    public void addEmployee ( Employee employee){
        repository.save(employee);
    }

    public void updateEmployee (Employee employee){
        repository.save(employee);
    }

    public Employee getEmployeeById (Long id){
        return repository.findById(id).get();
    }

    public void deleteEmployeeById ( Long id){
        repository.deleteById(id);
    }

    public Page<Employee> getEmployeesByPage(int page,int size){
        Pageable pageable =new PageRequest(page, size);
        Page<Employee> employees = repository.findAll(pageable);
        return  employees;
    }

    public List<Employee> getEmployeesByGender(String gender){
        return  repository.findByGender(gender);
    }


}
