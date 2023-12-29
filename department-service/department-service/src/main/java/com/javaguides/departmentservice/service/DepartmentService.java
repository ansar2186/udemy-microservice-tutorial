package com.javaguides.departmentservice.service;

import com.javaguides.departmentservice.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentById(String id);

    List<DepartmentDto> getAllDepartments();
}
