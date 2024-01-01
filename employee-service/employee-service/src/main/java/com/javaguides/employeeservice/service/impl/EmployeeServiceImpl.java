package com.javaguides.employeeservice.service.impl;

import com.javaguides.employeeservice.dto.EmployeeDto;
import com.javaguides.employeeservice.entity.Employee;
import com.javaguides.employeeservice.repository.EmployeeRepository;
import com.javaguides.employeeservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        //ModelMapper mapper= new ModelMapper();
        Employee employee = mapper.map(employeeDto, Employee.class);
        Employee saveEmployee = employeeRepository.save(employee);
        EmployeeDto employeeDto1 = mapper.map(saveEmployee, EmployeeDto.class);

        return employeeDto1;
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        EmployeeDto employeeDto = mapper.map(employee, EmployeeDto.class);
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> allEmployee = employeeRepository.findAll();
        List<EmployeeDto> employeeDtoList = allEmployee.stream().map(emp -> mapper.map(emp, EmployeeDto.class)).collect(Collectors.toList());

        return employeeDtoList;
    }
}
