package com.digdes.java2023.app;

import com.digdes.java2023.dto.EmployeeDto;
import com.digdes.java2023.enums.EmployeeStatus;
import com.digdes.java2023.exception.BusinessLogicException;
import com.digdes.java2023.repo.impl.EmployeeRepoDummy;
import com.digdes.java2023.service.EmployeeService;
import com.digdes.java2023.service.impl.EmployeeServiceDummy;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        EmployeeDto employeeDto1 = new EmployeeDto();
        employeeDto1.setFirstName("Алексей");
        employeeDto1.setSurName("Александрович");
        employeeDto1.setLastName("Алексеев");
        employeeDto1.setEmail("alexeevaa@gmail.com");
        employeeDto1.setAccount("AlexAA");
        employeeDto1.setStatus(EmployeeStatus.ACTIVE);

        EmployeeDto employeeDto2 = new EmployeeDto();
        employeeDto2.setFirstName("Иван");
        employeeDto2.setSurName("Александрович");
        employeeDto2.setLastName("Иванов");
        employeeDto2.setEmail("ivanovai@gmail.com");
        employeeDto2.setAccount("IvanovAI");
        employeeDto2.setStatus(EmployeeStatus.ACTIVE);

        EmployeeService employeeService = new EmployeeServiceDummy(new EmployeeRepoDummy(new ArrayList<>(), "employees.txt"));

        try{
            System.out.println("Создание:");
            employeeDto1 = employeeService.create(employeeDto1);
            employeeDto2 = employeeService.create(employeeDto2);
            System.out.println(employeeDto1);
            System.out.println(employeeDto2);

            System.out.println("\nПолучение:");
            // 6056c5ae-c9ed-4fd1-bdcb-a1556241d737
            // a4155456-8794-4526-bb4f-029ae6ffb728
            employeeDto1 = employeeService.getById(employeeDto1.getId());
            employeeDto2 = employeeService.getById(employeeDto2.getId());
            System.out.println(employeeDto1);
            System.out.println(employeeDto2);

            System.out.println("\nОбновление:");
            employeeDto1.setFirstName("Игорь");
            employeeDto1 = employeeService.update(employeeDto1);
            System.out.println(employeeDto1);

            System.out.println("\nУдаление:");
            employeeService.deleteById(employeeDto2.getId());

            for (EmployeeDto e : employeeService.getAll()){
                System.out.println(e);
            }

        } catch(BusinessLogicException e){
            System.out.println(e.getMessage());
        }
    }
}