package com.digdes.java2023.service;

import com.digdes.java2023.dto.EmployeeDto;
import com.digdes.java2023.exception.BLLException;
import com.digdes.java2023.model.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    Employee create(EmployeeDto dto) throws BLLException;
    Employee getById(UUID id) throws BLLException;
    List<Employee> getAll() throws BLLException;
    void deleteById(UUID id) throws BLLException;
    Employee dtoToEmployee(EmployeeDto dto);
    EmployeeDto employeeToDto(Employee employee);
    List<EmployeeDto> employeeListToDto(List<Employee> employees);
}
