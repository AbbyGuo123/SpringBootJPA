package com.oocl.springBootSqlTest.OneToN.Repository;

import com.oocl.springBootSqlTest.OneToN.Enity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
