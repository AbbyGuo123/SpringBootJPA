package com.oocl.springBootSqlTest.OneToN.Controller;

import com.oocl.springBootSqlTest.OneToN.Enity.Employee;
import com.oocl.springBootSqlTest.OneToN.Repository.EmployeeRepository;
import com.oocl.springBootSqlTest.OneToN.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Transactional
    @GetMapping(path = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getAllEmployee (){
        return employeeService.getAllEmployee();
    }

    @Transactional
    @PostMapping(path = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public void addEmployee (@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @Transactional
    @PutMapping(path = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateEmployee (@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    }

    @Transactional
    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getEmployeeById (@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @Transactional
    @DeleteMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteEmployeeById (@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
    }

    @Transactional
    @GetMapping(path = "/page")
    public Page<Employee> getEmployeesByPage(int page,int size){
        return employeeService.getEmployeesByPage(page, size);
    }


    @Transactional
    @GetMapping(path = "/gender")
    public List<Employee> getEmployeesByGender(String gender){
        return  employeeService.getEmployeesByGender(gender);
    }


}
