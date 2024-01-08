package com.javaguides.employeeservice.dto;

import lombok.Data;

@Data
public class DepartmentDto {
    private Long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
    private String port;
}
