package com.example.excel_dataImportAndFileExport.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class Employee {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
 
    private String empName;
 
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<EmployeeSalary> employeeSalary;
    
}
