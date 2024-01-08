package com.javaguides.departmentservice.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DepartmentDto {
    private Long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
    private String port;
}
