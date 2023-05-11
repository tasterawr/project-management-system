package com.digdes.java2023.repo;

import com.digdes.java2023.dto.EmployeeDto;
import com.digdes.java2023.exception.DALException;
import com.digdes.java2023.model.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeRepo {
    void create(Employee employee) throws DALException;
    Employee getById(UUID id) throws DALException;
    List<Employee> getAll() throws DALException;
    void deleteById(UUID id) throws DALException;
}
