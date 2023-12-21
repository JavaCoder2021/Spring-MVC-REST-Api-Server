package by.trofimov.spring.rest_server.dao;

import java.util.List;
import by.trofimov.spring.rest_server.entity.Employee;

public interface EmployeeDAO {

    List<Employee> getAllEmployees();

    void saveOrUpdateEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);

}
