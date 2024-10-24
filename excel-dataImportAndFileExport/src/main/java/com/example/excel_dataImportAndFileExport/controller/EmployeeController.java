package com.example.excel_dataImportAndFileExport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.excel_dataImportAndFileExport.model.Employee;
import com.example.excel_dataImportAndFileExport.service.EmployeeService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
 
    @Autowired
    private EmployeeService employeeService;
 
    @PostMapping("/upload")
    public ResponseEntity<String> uploadExcel(@RequestParam("file") MultipartFile file) {
        try {
            employeeService.importExcel(file);
            return ResponseEntity.ok("Data successfully imported");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to import data");
        }
    }

    @GetMapping("/getEmployeeDetails")
    public List<Employee> getEmployeeDetails() {
        return employeeService.getEmployees();
    }
}
