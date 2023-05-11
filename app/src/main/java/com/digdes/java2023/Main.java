package com.digdes.java2023;

import com.digdes.java2023.dto.EmployeeDto;
import com.digdes.java2023.exception.BLLException;
import com.digdes.java2023.model.Employee;
import com.digdes.java2023.repo.impl.EmployeeRepoDummy;
import com.digdes.java2023.service.EmployeeService;
import com.digdes.java2023.service.impl.EmployeeServiceDummy;

import java.util.UUID;


public class Main {
    public static void main(String[] args) {
        EmployeeDto employeeDto1 = new EmployeeDto();
        employeeDto1.setFirstName("Алексей");
        employeeDto1.setSurName("Александрович");
        employeeDto1.setLastName("Алексеев");
        employeeDto1.setEmail("alexeevaa@gmail.com");
        employeeDto1.setAccount("AlexAA");
        employeeDto1.setStatus("active");

        EmployeeDto employeeDto2 = new EmployeeDto();
        employeeDto2.setFirstName("Иван");
        employeeDto2.setSurName("Александрович");
        employeeDto2.setLastName("Иванов");
        employeeDto2.setEmail("ivanovai@gmail.com");
        employeeDto2.setAccount("IvanovAI");
        employeeDto2.setStatus("active");

        EmployeeService employeeService = new EmployeeServiceDummy(new EmployeeRepoDummy());

        try{
            System.out.println("Создание:");
            Employee employee1 = employeeService.create(employeeDto1);
            Employee employee2 = employeeService.create(employeeDto2);
            System.out.println(employee1);
            System.out.println(employee2);

            System.out.println("\nПолучение:");
            // 6056c5ae-c9ed-4fd1-bdcb-a1556241d737
            // a4155456-8794-4526-bb4f-029ae6ffb728
            employee1 = employeeService.getById(employee1.getId());
            employee2 = employeeService.getById(employee2.getId());
            System.out.println(employee1);
            System.out.println(employee2);

            System.out.println("\nУдаление:");
            employeeService.deleteById(employee2.getId());

            for (Employee e : employeeService.getAll()){
                System.out.println(e);
            }

        } catch(BLLException e){
            System.out.println(e.getMessage());
        }
    }
}