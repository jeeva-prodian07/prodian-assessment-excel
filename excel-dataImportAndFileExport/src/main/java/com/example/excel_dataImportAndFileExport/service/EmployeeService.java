package com.example.excel_dataImportAndFileExport.service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.excel_dataImportAndFileExport.model.Employee;
import com.example.excel_dataImportAndFileExport.model.EmployeeSalary;
import com.example.excel_dataImportAndFileExport.repository.EmployeeRepository;
import com.example.excel_dataImportAndFileExport.repository.SalaryRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
 
    public void importExcel(MultipartFile file) throws IOException {
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        // Sheet sheet = workbook.getSheetAt(0);
        org.apache.poi.ss.usermodel.Sheet sheet =  workbook.getSheetAt(0);
 
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue; 
            }
            Employee employee = new Employee();
            employee.setEmpName(row.getCell(1).getStringCellValue());
 
            EmployeeSalary salary = new EmployeeSalary();
            salary.setCreditedDate(row.getCell(2).getLocalDateTimeCellValue().toLocalDate());
            salary.setAmount(row.getCell(3).getNumericCellValue());
            salary.setEmployee(employee);
 
            employee.setEmployeeSalary(Collections.singletonList(salary));
            employeeRepository.save(employee); 
        }
 
        workbook.close();
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
}
