package com.oocl.springBootSqlTest.OneToN.DTO;

import com.oocl.springBootSqlTest.OneToN.Enity.Employee;

import java.time.ZonedDateTime;

public class EmployeeDTO {
    private long id;

    private String employeeName;

    private ZonedDateTime createDate ;

    private Long company_id;

    public long getId() {
        return id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public Long getCompany_id() {
        return company_id;
    }

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.employeeName = employee.getEmployeeName();
        this.createDate = employee.getCreateDate();
        this.company_id = employee.getCompany().getId();
    }
}
