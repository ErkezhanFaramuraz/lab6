package employee;

public class EmployeeMain {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeServiceImpl();

        try {
            service.addEmployee(new employee.Employee("E001", "Айжан", "IT", 350000, 3, true));
            service.addEmployee(new employee.Employee("E002", "Бекзат", "HR", 250000, 2, true));
            service.addEmployee(new employee.Employee("E003", "Еркежан", "IT", 400000, 5, true));
        } catch (Exception e) {
            System.out.println("Ошибка при добавлении: " + e.getMessage());
        }

        System.out.println("🔹 Все сотрудники:");
        service.printAllEmployees();

        System.out.println("\n🔹 Сотрудники отдела IT:");
        service.searchByDepartment("IT").forEach(System.out::println);

        System.out.println("\n🔹 Статистика по зарплатам:");
        System.out.println(service.getSalaryStatistics());

        System.out.println("\n🔹 Сотрудники со стажем 3+ лет:");
        service.filterEmployeesByExperience(3).forEach(System.out::println);

        try {
            System.out.println("\n🔹 Увольнение сотрудника E002:");
            service.fireEmployee("E002");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n🔹 После увольнения:");
        service.printAllEmployees();
    }
}