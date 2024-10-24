package com.example.excel_dataImportAndFileExport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.excel_dataImportAndFileExport.model.Employee;


@Repository
public interface EmployeeRepository extends  JpaRepository<Employee, Long> {

    @Query(nativeQuery = true,value = "SELECT e.employeeId,e.empName, s.amount, s.creditedDate from employee as e right join employeeSalary as s on  e.employeeId = s.salaryId")
    List <Employee> getEmployeeDetails();
} 
