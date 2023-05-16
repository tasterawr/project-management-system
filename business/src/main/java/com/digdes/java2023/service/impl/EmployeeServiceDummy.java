package com.digdes.java2023.service.impl;

import com.digdes.java2023.dto.EmployeeDto;
import com.digdes.java2023.exception.BLLException;
import com.digdes.java2023.exception.DALException;
import com.digdes.java2023.model.Employee;
import com.digdes.java2023.model.EmployeeStatus;
import com.digdes.java2023.repo.EmployeeRepo;
import com.digdes.java2023.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EmployeeServiceDummy implements EmployeeService {
    EmployeeRepo employeeRepo;

    public EmployeeServiceDummy(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee create(EmployeeDto dto) throws BLLException {
        Employee employee = dtoToEmployee(dto);
        employee.setId(UUID.randomUUID());
        try{
            employeeRepo.create(employee);
        } catch (DALException e){
            throw new BLLException(e.getMessage(), e);
        }

        return employee;
    }

    @Override
    public Employee getById(UUID id) throws BLLException {
        try {
            return employeeRepo.getById(id);
        } catch (DALException e){
            throw new BLLException(e.getMessage(), e);
        }
    }

    @Override
    public List<Employee> getAll() throws BLLException {
        try {
            return employeeRepo.getAll();
        } catch (DALException e){
            throw new BLLException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteById(UUID id) throws BLLException {
        try {
            employeeRepo.deleteById(id);
        }catch (DALException e){
            throw new BLLException(e.getMessage(), e);
        }
    }

    public Employee dtoToEmployee(EmployeeDto dto){
        com.digdes.java2023.model.Employee employee = new com.digdes.java2023.model.Employee();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setSurName(dto.getSurName());
        employee.setEmail(dto.getEmail());
        employee.setAccount(dto.getAccount());
        employee.setStatus(EmployeeStatus.valueOf(dto.getStatus().toUpperCase()));
        return employee;
    }

    public EmployeeDto employeeToDto(Employee employee){
        EmployeeDto dto = new EmployeeDto();
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setSurName(employee.getSurName());
        dto.setAccount(employee.getAccount());
        dto.setStatus(employee.getStatus().toString());
        dto.setEmail(employee.getEmail());
        return dto;
    }

    public List<EmployeeDto> employeeListToDto(List<Employee> employees){
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for (Employee e : employees){
            employeeDtos.add(employeeToDto(e));
        }

        return employeeDtos;
    }
}
