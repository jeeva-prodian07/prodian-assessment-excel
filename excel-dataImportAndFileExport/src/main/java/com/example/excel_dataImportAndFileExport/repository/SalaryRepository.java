package com.example.excel_dataImportAndFileExport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.excel_dataImportAndFileExport.model.EmployeeSalary;

public interface SalaryRepository extends JpaRepository <EmployeeSalary,Long> {

    
} 
