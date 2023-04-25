package com.example.employeemanagementapp.controller;

import com.example.employeemanagementapp.entity.EmployeeEntity;
import com.example.employeemanagementapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public List<EmployeeEntity> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/{email}")
    public Optional<EmployeeEntity> getEmployeeByEmail(@PathVariable String email){
        return employeeService.getEmployeeByEmail(email);
    }



    @PostMapping()
    public String addEmployee(@RequestBody EmployeeEntity employeeEntity) {
        employeeService.addEmployee(employeeEntity);
        return "Employee with email " + employeeEntity + " has been deleted successfully";
        
    }


    @DeleteMapping("/{email}")
    public String deleteEmployeeByEmail(@PathVariable("email") String email) {
        employeeService.deleteEmployeeByEmail(email);
        return "Employee with email " + email + " has been deleted successfully";

    }

}