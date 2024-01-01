package com.javaguides.employeeservice.controller;

import com.javaguides.employeeservice.dto.EmployeeDto;
import com.javaguides.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.saveEmployee(employeeDto), HttpStatus.CREATED);

    }
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);

    }
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        return new ResponseEntity<>(employeeService.getAllEmployee(),HttpStatus.OK);
    }
}
