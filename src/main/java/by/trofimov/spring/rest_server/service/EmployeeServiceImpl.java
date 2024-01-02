package by.trofimov.spring.rest_server.service;

import java.util.List;
import org.springframework.stereotype.Service;
import by.trofimov.spring.rest_server.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import by.trofimov.spring.rest_server.entity.Employee;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveOrUpdateEmployee(Employee employee) {
        employeeDAO.saveOrUpdateEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int employee) {
        return employeeDAO.getEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }

}
