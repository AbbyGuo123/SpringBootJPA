CREATE TABLE employee
(
    id BIGINT auto_increment primary key,
    employee_name varchar(20),
    gender varchar(20),
    create_date TIMESTAMP,
    company_id BIGINT
);