package com.javaguides.employeeservice.controller;

import com.javaguides.employeeservice.dto.ApiResponseDto;
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
    /*@GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);

    }*/

    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDto>  getEmployeeByEmpId(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.getEmployeeByEmpId(id),HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<ApiResponseDto>> getAllEmployee(){
        return new ResponseEntity<>(employeeService.getAllEmployeeApi(),HttpStatus.OK);
    }
}
