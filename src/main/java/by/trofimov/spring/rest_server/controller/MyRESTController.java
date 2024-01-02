package by.trofimov.spring.rest_server.controller;

import java.util.List;
import by.trofimov.spring.rest_server.entity.Employee;
import by.trofimov.spring.rest_server.exception_handling.NoSuchEmployeeException;
import by.trofimov.spring.rest_server.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static by.trofimov.spring.rest_server.util.Constant.*;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException(NO_EMPLOYEE_WITH_ID + id + IN_DATABASE);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeService.saveOrUpdateEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveOrUpdateEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException(NO_EMPLOYEE_WITH_ID + id + IN_DATABASE);
        }
        employeeService.deleteEmployee(id);
        return EMPLOYEE_WITH_ID + id + WAS_DELETED;
    }

}
