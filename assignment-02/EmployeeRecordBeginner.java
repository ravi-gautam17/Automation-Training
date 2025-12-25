import java.util.*;
import java.util.regex.Pattern;

/**
 *created a class named  Employee Record Management System that
 * Manages employee records using HashMap, Hashtable, and TreeMap.
 * Demonstrates add, display, search, remove operations,
 * null key/value behavior, REGEX validation, interfaces,
 * and exception handling.
 */

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;

/* ================= INTERFACE ================= */
interface EmployeeOperations {
    void addEmployee(String id, String name);
    void displayEmployees();
    void searchEmployee(String id);
    void removeEmployee(String id);
}

/* ================= EMPLOYEE CLASS ================= */
class Employee {
    String id;
    String name;

    Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return id + " - " + name;
    }
}

/* ================= MANAGER CLASS ================= */
class EmployeeManager implements EmployeeOperations {

    Map<String, Employee> hashMap = new HashMap<>();
    Map<String, Employee> hashTable = new Hashtable<>();
    Map<String, Employee> treeMap = new TreeMap<>();

    // Simple REGEX
    String ID_REGEX = "EMP[0-9]{3}";
    String NAME_REGEX = "[A-Za-z ]+";

    public void addEmployee(String id, String name) {

        if (!Pattern.matches(ID_REGEX, id)) {
            System.out.println("Invalid ID (Use EMP001 format)");
            return;
        }

        if (!Pattern.matches(NAME_REGEX, name)) {
            System.out.println("Invalid Name (Only letters allowed)");
            return;
        }

        Employee emp = new Employee(id, name);

        hashMap.put(id, emp);
        hashTable.put(id, emp);
        treeMap.put(id, emp);

        System.out.println("Employee Added Successfully");
    }

    public void displayEmployees() {

        System.out.println("\nHashMap Data:");
        System.out.println(hashMap);

        System.out.println("\nHashtable Data:");
        System.out.println(hashTable);

        System.out.println("\nTreeMap Data:");
        System.out.println(treeMap);
    }

    public void searchEmployee(String id) {

        if (hashMap.containsKey(id)) {
            System.out.println("Employee Found: " + hashMap.get(id));
        } else {
            System.out.println("Employee Not Found");
        }
    }

    public void removeEmployee(String id) {

        if (hashMap.containsKey(id)) {
            hashMap.remove(id);
            hashTable.remove(id);
            treeMap.remove(id);
            System.out.println("Employee Removed");
        } else {
            System.out.println("Employee Not Found");
        }
    }

   
    public void showNullSupport() {

        System.out.println("\n--- Null Support Demo ---");

        hashMap.put(null, new Employee("NULL", "NullUser"));
        hashMap.put("EMP999", null);

        System.out.println("HashMap allows null key & value");
        System.out.println(hashMap);

        System.out.println("Hashtable & TreeMap do NOT allow null key");
    }
}

/* ================= MAIN CLASS ================= */
public class EmployeeRecordBeginner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();

        try {
            while (true) {

                System.out.println("\n--- EMPLOYEE MENU ---");
                System.out.println("1. Add Employee");
                System.out.println("2. Display Employees");
                System.out.println("3. Search Employee");
                System.out.println("4. Remove Employee");
                System.out.println("5. Show Null Support");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine(); // clear buffer

                if (choice == 1) {
                    System.out.print("Enter Employee ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    manager.addEmployee(id, name);

                } else if (choice == 2) {
                    manager.displayEmployees();

                } else if (choice == 3) {
                    System.out.print("Enter Employee ID: ");
                    manager.searchEmployee(sc.nextLine());

                } else if (choice == 4) {
                    System.out.print("Enter Employee ID: ");
                    manager.removeEmployee(sc.nextLine());

                } else if (choice == 5) {
                    manager.showNullSupport();

                } else if (choice == 6) {
                    System.out.println("Exiting Program...");
                    break;

                } else {
                    System.out.println("Invalid Choice");
                }
            }

        } catch (Exception e) {
            System.out.println("Input Error. Please try again.");
        }

        sc.close();
    }
}