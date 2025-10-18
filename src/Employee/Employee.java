package employee;

public class Employee {
    private String employeeId;
    private String name;
    private String department;
    private double salary;
    private int experienceYears;
    private boolean isActive;

    public Employee(String employeeId, String name, String department, double salary, int experienceYears, boolean isActive) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.experienceYears = experienceYears;
        this.isActive = isActive;
    }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public int getExperienceYears() { return experienceYears; }
    public void setExperienceYears(int experienceYears) { this.experienceYears = experienceYears; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    @Override
    public String toString() {
        return String.format("Employee{id='%s', name='%s', dept='%s', salary=%.2f, exp=%d, active=%s}",
                employeeId, name, department, salary, experienceYears, isActive ? "Yes" : "No");
    }
}
