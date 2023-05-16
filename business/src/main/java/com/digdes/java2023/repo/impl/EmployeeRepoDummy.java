package com.digdes.java2023.repo.impl;

import com.digdes.java2023.enums.EmployeeStatus;
import com.digdes.java2023.model.Employee;
import com.digdes.java2023.repo.EmployeeRepo;
import com.digdes.java2023.exception.DataAccessLayerException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EmployeeRepoDummy implements EmployeeRepo {
    private List<Employee> employeeCache;
    private final String STORAGE_PATH;

    public EmployeeRepoDummy(List<Employee> employeeCache, String storage_path) {
        this.employeeCache = employeeCache;
        this.STORAGE_PATH = storage_path;
    }

    @Override
    public Employee create(Employee employee) throws DataAccessLayerException {
        if (!Files.exists(Path.of(STORAGE_PATH))){
            try {
                Files.createFile(Path.of(STORAGE_PATH));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(STORAGE_PATH))){
            employee.setId(UUID.randomUUID());
            employeeCache.add(employee);
            os.writeObject(employeeCache);
            return employee;
        } catch (FileNotFoundException e) {
            throw new DataAccessLayerException(e.getMessage());
        } catch (IOException e){
            throw new DataAccessLayerException("Error creating employee: ", e);
        }
    }

    @Override
    public Employee update(Employee employee) throws DataAccessLayerException {
        Employee old = getByIdFromCash(employee.getId());
        if (old == null){
            return create(employee);
        } else {
            employeeCache.remove(old);
            employeeCache.add(employee);
            try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(STORAGE_PATH))){
                os.writeObject(employeeCache);
                return employee;
            } catch (FileNotFoundException e) {
                throw new DataAccessLayerException(e.getMessage());
            } catch (IOException e){
                throw new DataAccessLayerException("Error updating employee: ", e);
            }
        }
    }

    @Override
    public Employee getById(UUID id) throws DataAccessLayerException {
        Employee employee = getByIdFromCash(id);

        if (employee == null){
            if (Files.exists(Path.of(STORAGE_PATH))){
                try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(STORAGE_PATH))){
                    employeeCache = (List<Employee>) is.readObject();
                    employee = getByIdFromCash(id);
                    if (employee == null){
                        throw new DataAccessLayerException("No employee with id: " + id.toString());
                    }
                } catch (FileNotFoundException e) {
                    throw new DataAccessLayerException(e.getMessage());
                } catch (IOException e){
                    throw new DataAccessLayerException("Error getting employee: ", e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new DataAccessLayerException("No employee with id: " + id.toString());
            }
        }
        return employee;
    }

    private Employee getByIdFromCash(UUID id){
        return employeeCache.stream().
                filter(e -> e.getId().equals(id)).
                findFirst().orElse(null);
    }

    @Override
    public List<Employee> getAll() throws DataAccessLayerException {
        if (Files.exists(Path.of(STORAGE_PATH))){
            try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(STORAGE_PATH))){
                employeeCache = (List<Employee>) is.readObject();
            } catch (FileNotFoundException e) {
                throw new DataAccessLayerException(e.getMessage());
            } catch (IOException e){
                throw new DataAccessLayerException("Error getting employees: ", e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        return new ArrayList<>(employeeCache);
    }

    @Override
    public void deleteById(UUID id) throws DataAccessLayerException {
        if (!Files.exists(Path.of(STORAGE_PATH))){
            throw new DataAccessLayerException("No employee with id: " + id.toString());
        }

        try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(STORAGE_PATH));
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(STORAGE_PATH))){
            Employee employee = getByIdFromCash(id);
            if (employee == null){
                employeeCache = (List<Employee>) is.readObject();
            }

            employee = getByIdFromCash(id);
            if (employee == null){
                throw new DataAccessLayerException("No employee with id: " + id.toString());
            } else {
                employee.setStatus(EmployeeStatus.DELETED);
                os.writeObject(employeeCache);
            }
        } catch (FileNotFoundException e) {
            throw new DataAccessLayerException(e.getMessage());
        } catch (IOException e){
            throw new DataAccessLayerException("Error deleting employee: ", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
