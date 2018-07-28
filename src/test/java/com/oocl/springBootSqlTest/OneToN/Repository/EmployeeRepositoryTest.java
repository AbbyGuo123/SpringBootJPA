package com.oocl.springBootSqlTest.OneToN.Repository;

import com.oocl.springBootSqlTest.OneToN.Enity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void findByGender() {

        //given
        testEntityManager.persist(new Employee("aa","male"));
        testEntityManager.persist(new Employee("aa1","female"));
        //when
        List<Employee> employees = employeeRepository.findByGender("male");
        //then
        assertThat(employees.size(),is(1));
    }

    @Test
    public void findByPageTest(){
        //given
        testEntityManager.persist(new Employee("c1","male"));
        testEntityManager.persist(new Employee("c2","female"));
        //when
        Page<Employee> companies = employeeRepository.findAll(PageRequest.of(1,1));
        //then
        assertThat(companies.getContent().size(),is(1));
        assertThat(companies.getContent().get(0).getEmployeeName(),is("c2"));
    }
}