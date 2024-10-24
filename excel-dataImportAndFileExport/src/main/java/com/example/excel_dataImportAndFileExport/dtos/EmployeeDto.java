package com.example.excel_dataImportAndFileExport.dtos;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.excel_dataImportAndFileExport.model.Employee;
import com.example.excel_dataImportAndFileExport.model.EmployeeSalary;

import lombok.Data;

@Data
public class EmployeeDto {
  
    private Employee employee;
    private EmployeeSalary employeeSalary;
}
