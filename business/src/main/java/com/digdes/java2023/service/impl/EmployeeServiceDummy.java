package com.digdes.java2023.service.impl;

import com.digdes.java2023.dto.EmployeeDto;
import com.digdes.java2023.exception.BusinessLogicException;
import com.digdes.java2023.exception.DataAccessLayerException;
import com.digdes.java2023.model.Employee;
import com.digdes.java2023.repo.EmployeeRepo;
import com.digdes.java2023.service.EmployeeService;

import java.util.List;
import java.util.UUID;

public class EmployeeServiceDummy implements EmployeeService {
    EmployeeRepo employeeRepo;

    public EmployeeServiceDummy(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public EmployeeDto create(EmployeeDto dto) throws BusinessLogicException {
        Employee employee = dtoToEmployee(dto);
        try{
            return employeeToDto(employeeRepo.create(employee));
        } catch (DataAccessLayerException e){
            throw new BusinessLogicException(e.getMessage(), e);
        }
    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto) throws BusinessLogicException {
        try{
            Employee employee = dtoToEmployee(employeeDto);
            return employeeToDto(employeeRepo.update(employee));
        } catch (DataAccessLayerException e){
            throw new BusinessLogicException(e.getMessage(), e);
        }
    }

    @Override
    public EmployeeDto getById(UUID id) throws BusinessLogicException {
        try {
            return employeeToDto(employeeRepo.getById(id));
        } catch (DataAccessLayerException e){
            throw new BusinessLogicException(e.getMessage(), e);
        }
    }

    @Override
    public List<EmployeeDto> getAll() throws BusinessLogicException {
        try {
            return employeeListToDto(employeeRepo.getAll());
        } catch (DataAccessLayerException e){
            throw new BusinessLogicException(e.getMessage(), e);
        }
    }

    @Override
    public EmployeeDto deleteById(UUID id) throws BusinessLogicException {
        try {
            return employeeToDto(employeeRepo.deleteById(id));
        }catch (DataAccessLayerException e){
            throw new BusinessLogicException(e.getMessage(), e);
        }
    }
}
