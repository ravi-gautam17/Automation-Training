import java.util.*;
import java.util.regex.Pattern;

/* ================= INTERFACE ================= */
interface StudentOperations {
    void addStudent(String id, String name, int marks, String course);
    void displayStudents();
    void searchStudent(String id);
    void removeStudent(String id);
}

/* ================= STUDENT CLASS ================= */
class Student {
    String id;
    String name;
    int marks;
    String course;

    Student(String id, String name, int marks, String course) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.course = course;
    }

    public String toString() {
        return id + " | " + name + " | " + marks + " | " + course;
    }
}

/* ================= MANAGER CLASS ================= */
class UniversityManager implements StudentOperations {

    // List implementations
    List<Student> studentList = new ArrayList<>();
    Vector<Student> studentVector = new Vector<>();
    Stack<Student> studentStack = new Stack<>();

    // Map for ID based storage
    Map<String, Student> studentMap = new HashMap<>();

    // Set to store unique courses
    Set<String> courseSet = new HashSet<>();

    // REGEX
    String ID_REGEX = "STU[0-9]{3}";
    String NAME_REGEX = "[A-Za-z ]+";

    /* ---------- ADD STUDENT ---------- */
    public void addStudent(String id, String name, int marks, String course) {

        if (!Pattern.matches(ID_REGEX, id)) {
            System.out.println("Invalid ID (Use STU001 format)");
            return;
        }

        if (!Pattern.matches(NAME_REGEX, name)) {
            System.out.println("Invalid Name");
            return;
        }

        if (studentMap.containsKey(id)) {
            System.out.println("Duplicate Student ID not allowed");
            return;
        }

        Student s = new Student(id, name, marks, course);

        studentList.add(s);
        studentVector.add(s);
        studentStack.push(s);
        studentMap.put(id, s);
        courseSet.add(course);

        System.out.println("Student Added Successfully");
    }

    /* ---------- DISPLAY ---------- */
    public void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found");
            return;
        }

        System.out.println("\nID | Name | Marks | Course");
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    /* ---------- SEARCH ---------- */
    public void searchStudent(String id) {
        if (studentMap.containsKey(id)) {
            System.out.println("Student Found: " + studentMap.get(id));
        } else {
            System.out.println("Student Not Found");
        }
    }

    /* ---------- REMOVE ---------- */
    public void removeStudent(String id) {
        Student s = studentMap.get(id);

        if (s == null) {
            System.out.println("Student Not Found");
            return;
        }

        studentList.remove(s);
        studentVector.remove(s);
        studentStack.remove(s);
        studentMap.remove(id);

        System.out.println("Student Removed");
    }

    /* ---------- SORT BY MARKS ---------- */
    public void sortByMarks() {
        Collections.sort(studentList, new Comparator<Student>() {
            public int compare(Student a, Student b) {
                return b.marks - a.marks;
            }
        });
        System.out.println("Students Sorted by Marks");
    }

    /* ---------- COUNT COURSE-WISE ---------- */
    public void countCourseWise() {
        Map<String, Integer> countMap = new HashMap<>();

        for (Student s : studentList) {
            countMap.put(s.course, countMap.getOrDefault(s.course, 0) + 1);
        }

        System.out.println("Course-wise Student Count:");
        System.out.println(countMap);
    }

    /* ---------- DISPLAY UNIQUE COURSES ---------- */
    public void displayCourses() {
        System.out.println("Available Courses:");
        for (String c : courseSet) {
            System.out.println(c);
        }
    }

    /* ---------- HASHMAP TO TREEMAP ---------- */
    public void convertHashMapToTreeMap() {
        TreeMap<String, Student> treeMap = new TreeMap<>(studentMap);
        System.out.println("TreeMap (Sorted by Student ID):");
        System.out.println(treeMap);
    }
}

/* ================= MAIN CLASS ================= */
public class UniversityStudentSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UniversityManager manager = new UniversityManager();

        try {
            while (true) {

                System.out.println("\n--- UNIVERSITY MENU ---");
                System.out.println("1. Add Student");
                System.out.println("2. Display Students");
                System.out.println("3. Search Student");
                System.out.println("4. Remove Student");
                System.out.println("5. Sort Students by Marks");
                System.out.println("6. Count Students Course-wise");
                System.out.println("7. Display All Courses");
                System.out.println("8. Convert HashMap to TreeMap");
                System.out.println("9. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("ID: ");
                        String id = sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Marks: ");
                        int marks = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Course: ");
                        String course = sc.nextLine();
                        manager.addStudent(id, name, marks, course);
                        break;

                    case 2:
                        manager.displayStudents();
                        break;

                    case 3:
                        System.out.print("Enter ID: ");
                        manager.searchStudent(sc.nextLine());
                        break;

                    case 4:
                        System.out.print("Enter ID: ");
                        manager.removeStudent(sc.nextLine());
                        break;

                    case 5:
                        manager.sortByMarks();
                        break;

                    case 6:
                        manager.countCourseWise();
                        break;

                    case 7:
                        manager.displayCourses();
                        break;

                    case 8:
                        manager.convertHashMapToTreeMap();
                        break;

                    case 9:
                        System.out.println("Exiting...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid Choice");
                }
            }
        } catch (Exception e) {
            System.out.println("Input Error");
            sc.close();
        }
    }
}