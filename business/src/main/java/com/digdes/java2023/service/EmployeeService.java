package com.digdes.java2023.service;

import com.digdes.java2023.dto.EmployeeDto;
import com.digdes.java2023.exception.BusinessLogicException;

import java.util.List;
import java.util.UUID;

public interface EmployeeService extends ServiceDtoMapper{
    EmployeeDto create(EmployeeDto dto) throws BusinessLogicException;
    EmployeeDto update(EmployeeDto employeeDto) throws BusinessLogicException;
    EmployeeDto getById(UUID id) throws BusinessLogicException;
    List<EmployeeDto> getAll() throws BusinessLogicException;
    void deleteById(UUID id) throws BusinessLogicException;
}
