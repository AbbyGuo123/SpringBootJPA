package com.oocl.springBootSqlTest.OneToN.Controller;

import com.oocl.springBootSqlTest.OneToN.Enity.Employee;
import com.oocl.springBootSqlTest.OneToN.Repository.EmployeeRepository;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @GetMapping(path = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getAllEmployee (){
        return repository.findAll();
    }

    @Transactional
    @PostMapping(path = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public void addEmployee (@RequestBody Employee employee){
        repository.save(employee);
    }

    @Transactional
    @PutMapping(path = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateEmployee (@RequestBody Employee employee){
        repository.save(employee);
    }

    @Transactional
    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getEmployeeById (@PathVariable Long id){
        return repository.findById(id).get();
    }
}
