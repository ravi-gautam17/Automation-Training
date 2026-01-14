import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LoginService login = new LoginService();

        if (!login.login()) {
            System.out.println(" Login Failed");
            return;
        }

        EmployeeService service = new EmployeeService();

        while (true) {
            System.out.println("""
                \n1.Add Employee
                2.Display All
                3.Search by ID
                4.Update Salary
                5.Delete Employee
                6.Display Sorted
                7.Display Departments
                8.Exit
                """);

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Salary: ");
                        double sal = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Dept: ");
                        String dept = sc.nextLine();

                        service.addEmployee(
                                new Employee(id, name, sal, dept));
                    }
                    case 2 -> service.displayAll();
                    case 3 -> {
                        System.out.print("Enter ID: ");
                        service.searchById(sc.nextInt());
                    }
                    case 4 -> {
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        System.out.print("New Salary: ");
                        service.updateSalary(id, sc.nextDouble());
                    }
                    case 5 -> {
                        System.out.print("ID: ");
                        service.deleteEmployee(sc.nextInt());
                    }
                    case 6 -> service.displaySorted();
                    case 7 -> service.displayDepartments();
                    case 8 -> {
                        System.out.println(" Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice");
                }
            } catch (CustomException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
