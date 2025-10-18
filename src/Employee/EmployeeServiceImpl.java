package employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employeeMap = new HashMap<>();

    @Override
    public boolean addEmployee(Employee employee) throws IllegalArgumentException {
        if (employee == null) throw new IllegalArgumentException("Employee cannot be null");
        if (employeeMap.containsKey(employee.getEmployeeId()))
            throw new IllegalArgumentException("Employee ID already exists: " + employee.getEmployeeId());
        employeeMap.put(employee.getEmployeeId(), employee);
        return true;
    }

    @Override
    public boolean fireEmployee(String employeeId) throws Exception {
        Employee removed = employeeMap.remove(employeeId);
        if (removed == null) throw new Exception("Employee not found: " + employeeId);
        return true;
    }

    @Override
    public List<Employee> searchByDepartment(String department) {
        if (department == null) return Collections.emptyList();
        return employeeMap.values().stream()
                .filter(e -> department.equalsIgnoreCase(e.getDepartment()))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, Double> getSalaryStatistics() {
        List<Employee> employees = new ArrayList<>(employeeMap.values());
        if (employees.isEmpty()) return Map.of("average", 0.0, "max", 0.0, "min", 0.0);

        double avg = employees.stream().mapToDouble(Employee::getSalary).average().orElse(0);
        double max = employees.stream().mapToDouble(Employee::getSalary).max().orElse(0);
        double min = employees.stream().mapToDouble(Employee::getSalary).min().orElse(0);

        return Map.of("average", avg, "max", max, "min", min);
    }

    @Override
    public List<Employee> filterEmployeesByExperience(int minExperience) {
        return employeeMap.values().stream()
                .filter(e -> e.getExperienceYears() >= minExperience)
                .collect(Collectors.toList());
    }

    @Override
    public void printAllEmployees() {
        if (employeeMap.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        employeeMap.values().forEach(System.out::println);
    }
}