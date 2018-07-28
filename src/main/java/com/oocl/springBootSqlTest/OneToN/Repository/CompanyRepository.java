package com.oocl.springBootSqlTest.OneToN.Repository;

import com.oocl.springBootSqlTest.OneToN.Enity.Company;
import com.oocl.springBootSqlTest.OneToN.Enity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
    Page<Company> findAll(Pageable pageable);
}
