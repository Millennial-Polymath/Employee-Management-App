package com.example.employeemanagementapp.service;

import com.example.employeemanagementapp.entity.EmployeeEntity;
import com.example.employeemanagementapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public void addEmployee(EmployeeEntity employee) {
        Optional<EmployeeEntity> employeeByEmail = employeeRepository.getEmployeeByEmail(employee.getEmail());
        if (employeeByEmail.isPresent()) {
            throw new IllegalStateException("Employee exists");
        }

        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeByEmail(String email) {
//        Optional<EmployeeEntity> employeeByEmail = employeeRepository.getEmployeeByEmail(email);
            employeeRepository.deleteEmployeeByEmail(email);

    }

    @Override

    //public List<EmployeeEntity> getAllEmployees() {
     //   return employeeRepository.getAllEmployee();
   // }
    public List<EmployeeEntity> getAllEmployees(){
        return employeeRepository.getAllEmployee();

    }
    @Override
    public Optional<EmployeeEntity> getEmployeeByEmail(String email) {
        Optional<EmployeeEntity> employee = employeeRepository.getEmployeeByEmail(email);
        return employee;

    }
}