package com.example.employeemanagementapp.repository;


import com.example.employeemanagementapp.entity.EmployeeEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    @Query("FROM EmployeeEntity e WHERE e.email = :email")
    //Optional<EmployeeEntity> getEmployeeByEmail(@Param("email") String email);
    Optional<EmployeeEntity> getEmployeeByEmail(@Param("email") String email);


//    @Modifying
//    @Transactional
//    @Query(value = "INSERT INTO employeeEntity (name, email, dob) VALUES (:name, :email, :dob)", nativeQuery = true)
//    public String addEmployee(@Param("name") String name, @Param("email") String email, @Param("dob") LocalDate dob);

    @Modifying
    @Transactional
    @Query("DELETE FROM EmployeeEntity e WHERE e.email = :email")
    public void deleteEmployeeByEmail(String email);

    @Query("FROM EmployeeEntity e")
    public List<EmployeeEntity> getAllEmployee();

}