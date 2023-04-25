package com.example.employeemanagementapp.service;

import com.example.employeemanagementapp.entity.EmployeeEntity;
import java.util.*;

public interface EmployeeService {
    public void addEmployee(EmployeeEntity employee);

    public void deleteEmployeeByEmail(String email);

    //public List<EmployeeEntity> getAllEmployees();
    public List<EmployeeEntity> getAllEmployees();

    public Optional<EmployeeEntity> getEmployeeByEmail(String email);



}