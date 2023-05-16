package com.digdes.java2023.repo;

import com.digdes.java2023.exception.DataAccessLayerException;
import com.digdes.java2023.model.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeRepo {
    Employee create(Employee employee) throws DataAccessLayerException;
    Employee update(Employee employee) throws DataAccessLayerException;
    Employee getById(UUID id) throws DataAccessLayerException;
    List<Employee> getAll() throws DataAccessLayerException;
    void deleteById(UUID id) throws DataAccessLayerException;
}
