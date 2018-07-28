package com.oocl.springBootSqlTest.OneToN.Repository;

import com.oocl.springBootSqlTest.OneToN.Enity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query("select t from Employee t where t.gender= ?1")
    List<Employee> findByGender(String status);

}
