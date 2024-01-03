package com.javaguides.employeeservice.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String departmentCode;
    //private DepartmentDto departmentDto;
}
