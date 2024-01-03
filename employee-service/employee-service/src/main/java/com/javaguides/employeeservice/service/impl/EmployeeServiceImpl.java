package com.javaguides.employeeservice.service.impl;

import com.javaguides.employeeservice.dto.ApiResponseDto;
import com.javaguides.employeeservice.dto.DepartmentDto;
import com.javaguides.employeeservice.dto.EmployeeDto;
import com.javaguides.employeeservice.entity.Employee;
import com.javaguides.employeeservice.repository.EmployeeRepository;
import com.javaguides.employeeservice.service.ApiCleint;
import com.javaguides.employeeservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ApiCleint apiCleint;

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
    public ApiResponseDto getEmployeeByEmpId(Long id) {

        Employee employee = employeeRepository.findById(id).get();

        EmployeeDto employeeDto = mapper.map(employee, EmployeeDto.class);
        DepartmentDto departmentDto = apiCleint.getDepartmentById(employee.getDepartmentCode());

        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> allEmployee = employeeRepository.findAll();
        List<EmployeeDto> employeeDtoList = allEmployee.stream().map(emp -> mapper.map(emp, EmployeeDto.class)).collect(Collectors.toList());
        return employeeDtoList;
    }

    @Override
    public List<ApiResponseDto> getAllEmployeeApi() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDto> empDtoList = employeeList.stream().map(empList -> mapper.map(empList, EmployeeDto.class)).collect(Collectors.toList());
        List<DepartmentDto> allDepartments = apiCleint.getAllDepartments();
        List<ApiResponseDto> apiResponseDtoList= new ArrayList<>();
        System.out.println(empDtoList.get(0));
        for (int i = 0; i <empDtoList.size() ; i++) {
            for (int j = i; j <allDepartments.size(); j++) {
                apiResponseDtoList.add(new ApiResponseDto(empDtoList.get(i),allDepartments.get(j)));
                break;
            }
        }
        return apiResponseDtoList;
    }

}
