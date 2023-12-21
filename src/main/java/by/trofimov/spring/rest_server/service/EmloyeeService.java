package by.trofimov.spring.rest_server.service;

import java.util.List;
import by.trofimov.spring.rest_server.entity.Employee;

public interface EmloyeeService {

    List<Employee> getAllEmployees();

    void saveOrUpdateEmployee(Employee employee);

    Employee getEmployee(int employee);

    void deleteEmployee(int id);

}
