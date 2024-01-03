package com.javaguides.employeeservice.service;

import com.javaguides.employeeservice.dto.ApiResponseDto;
import com.javaguides.employeeservice.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);

    ApiResponseDto getEmployeeByEmpId(Long id);

    List<EmployeeDto> getAllEmployee();

    List<ApiResponseDto> getAllEmployeeApi();
}
