package com.javaguides.employeeservice.service;

import com.javaguides.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "http://localhost:8088",value ="DEPARTMENT-SERVICE")
public interface ApiCleint {

    @GetMapping("/api/departments/{department_code}")
   public DepartmentDto getDepartmentById(@PathVariable("department_code") String department_code);

    @GetMapping("/api/departments")
    public List<DepartmentDto> getAllDepartments();
}
