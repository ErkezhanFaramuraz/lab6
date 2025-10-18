package employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    boolean addEmployee(employee.Employee employee) throws IllegalArgumentException;
    boolean fireEmployee(String employeeId) throws Exception;
    List<employee.Employee> searchByDepartment(String department);
    Map<String, Double> getSalaryStatistics();
    List<employee.Employee> filterEmployeesByExperience(int minExperience);
    void printAllEmployees();
}