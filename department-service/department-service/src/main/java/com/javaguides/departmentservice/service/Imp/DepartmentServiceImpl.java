package com.javaguides.departmentservice.service.Imp;

import com.javaguides.departmentservice.dto.DepartmentDto;
import com.javaguides.departmentservice.entity.Department;
import com.javaguides.departmentservice.repository.DepartmentRepository;
import com.javaguides.departmentservice.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private Environment environment;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //convert departmnetDto to JPA department entity
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
        Department savedDept = departmentRepository.save(department);
        DepartmentDto departmentDto1 = new DepartmentDto(
                savedDept.getId(), savedDept.getDepartmentName(), savedDept.getDepartmentDescription(),
                savedDept.getDepartmentCode(), environment.getProperty("local.server.port")
        );
        return departmentDto1;
    }

    @Override
    public DepartmentDto getDepartmentById(String id) {
        Department department = departmentRepository.findDepartmentByDepartmentCode(id);
        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode(), environment.getProperty("local.server.port")
        );
        return departmentDto;
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        ModelMapper modelMapper = new ModelMapper();
        List<Department> all = departmentRepository.findAll();
        List<DepartmentDto> departmentDtoList = all.stream().map((dept -> modelMapper.map(dept, DepartmentDto.class))).collect(Collectors.toList());
        List<DepartmentDto> list = new CopyOnWriteArrayList<>(departmentDtoList);
        //DepartmentDto departmentDtoObj= new DepartmentDto();
        for (DepartmentDto departmentDto : list) {
            departmentDto.setPort(environment.getProperty("local.server.port"));
            list.add(departmentDto);
        }
        return list;
    }
}
