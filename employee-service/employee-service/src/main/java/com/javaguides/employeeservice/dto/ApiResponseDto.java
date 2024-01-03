package com.javaguides.employeeservice.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApiResponseDto {
    private EmployeeDto employee;
    private DepartmentDto department;

}
