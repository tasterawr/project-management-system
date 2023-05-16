package com.digdes.java2023.service;

import com.digdes.java2023.dto.EmployeeDto;
import com.digdes.java2023.model.Employee;

import java.util.ArrayList;
import java.util.List;

public interface ServiceDtoMapper {
    default Employee dtoToEmployee(EmployeeDto dto){
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setSurName(dto.getSurName());
        employee.setEmail(dto.getEmail());
        employee.setAccount(dto.getAccount());
        employee.setStatus(dto.getStatus());
        return employee;
    }
    default EmployeeDto employeeToDto(Employee employee){
        EmployeeDto dto = new EmployeeDto();
        dto.setId(employee.getId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setSurName(employee.getSurName());
        dto.setAccount(employee.getAccount());
        dto.setStatus(employee.getStatus());
        dto.setEmail(employee.getEmail());
        return dto;
    }

    default List<EmployeeDto> employeeListToDto(List<Employee> employees){
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for (Employee e : employees){
            employeeDtos.add(employeeToDto(e));
        }

        return employeeDtos;
    }
}
