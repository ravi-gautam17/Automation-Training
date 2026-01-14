import java.util.*;

public class EmployeeService {
    private HashMap<Integer, Employee> empMap;

    public EmployeeService() {
        empMap = FileUtil.load();
    }

    public void addEmployee(Employee emp) throws CustomException {
        if (empMap.containsKey(emp.getId()))
            throw new CustomException("Employee ID must be unique");

        if (emp.getSalary() <= 0)
            throw new CustomException("Salary must be positive");

        if (emp.getDepartment().isEmpty())
            throw new CustomException("Department cannot be empty");

        empMap.put(emp.getId(), emp);
        FileUtil.save(empMap);
        System.out.println("✅ Employee added successfully");
    }

    public void displayAll() {
        empMap.values().forEach(System.out::println);
    }

    public void searchById(int id) {
        System.out.println(empMap.getOrDefault(id, null));
    }

    public void updateSalary(int id, double salary) throws CustomException {
        if (salary <= 0)
            throw new CustomException("Salary must be positive");

        Employee emp = empMap.get(id);
        if (emp == null)
            throw new CustomException("Employee not found");

        emp.setSalary(salary);
        FileUtil.save(empMap);
        System.out.println(" Salary updated");
    }

    public void deleteEmployee(int id) throws CustomException {
        if (empMap.remove(id) == null)
            throw new CustomException("Employee not found");

        FileUtil.save(empMap);
        System.out.println(" Employee deleted");
    }

    public void displaySorted() {
        empMap.values().stream()
                .sorted(Comparator.comparing(Employee::getId))
                .forEach(System.out::println);
    }

    public void displayDepartments() {
        empMap.values().stream()
                .map(Employee::getDepartment)
                .distinct()
                .forEach(System.out::println);
    }
}
