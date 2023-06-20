import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Portal portal = new Portal();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMenu();
    }

    private static void displayMenu() {
        System.out.println("Student Portal");
        System.out.println("-------------------------");
        System.out.println("1. Add Undergraduate Student");
        System.out.println("2. Add Graduate Student");
        System.out.println("3. Add Course");
        System.out.println("4. Enroll Student in Course");
        System.out.println("5. Save Students to File");
        System.out.println("6. Save Courses to File");
        System.out.println("7. Load Students from File");
        System.out.println("8. Load Courses from File");
        System.out.println("9. Exit");
        System.out.println("-------------------------");

        int choice = getUserChoice();
        handleUserChoice(choice);
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private static void handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                addUndergraduateStudent();
                break;
            case 2:
                addGraduateStudent();
                break;
            case 3:
                addCourse();
                break;
            case 4:
                enrollStudentInCourse();
                break;
            case 5:
                saveStudentsToFile();
                break;
            case 6:
                saveCoursesToFile();
                break;
            case 7:
                loadStudentsFromFile();
                break;
            case 8:
                loadCoursesFromFile();
                break;
            case 9:
                System.out.println("Exiting...");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        displayMenu();
    }

    private static void addUndergraduateStudent() {
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student email: ");
        String email = scanner.nextLine();

        Student student = new UndergraduateStudent(studentId, name, email);
        portal.addStudent(student);
        System.out.println("Undergraduate student added successfully!");
    }

    private static void addGraduateStudent() {
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student email: ");
        String email = scanner.nextLine();

        Student student = new GraduateStudent(studentId, name, email);
        portal.addStudent(student);
        System.out.println("Graduate student added successfully!");
    }

    private static void addCourse() {
        System.out.print("Enter course ID: ");
        int courseId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter course title: ");
        String title = scanner.nextLine();

        System.out.print("Enter course instructor: ");
        String instructor = scanner.nextLine();

        System.out.print("Enter course credits: ");
        int credits = scanner.nextInt();

        Course course = new Course(courseId, title, instructor, credits);
        portal.addCourse(course);
        System.out.println("Course added successfully!");
    }

    private static void enrollStudentInCourse() {
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();

        System.out.print("Enter course ID: ");
        int courseId = scanner.nextInt();

        portal.enrollStudentInCourse(studentId, courseId);
        System.out.println("Student enrolled in the course successfully!");
    }

    private static void saveStudentsToFile() {
        System.out.print("Enter filename to save students: ");
        String filename = scanner.next();

        ArrayList<Student> students = portal.getStudents();
        try {
            FileHandler.writeStudentsToFile(students, filename);
            System.out.println("Students saved to file successfully!");
        } catch (IOException e) {
            System.out.println("Error saving students to file: " + e.getMessage());
        }
    }

    private static void saveCoursesToFile() {
        System.out.print("Enter filename to save courses: ");
        String filename = scanner.next();

        ArrayList<Course> courses = portal.getCourses();
        try {
            FileHandler.writeCoursesToFile(courses, filename);
            System.out.println("Courses saved to file successfully!");
        } catch (IOException e) {
            System.out.println("Error saving courses to file: " + e.getMessage());
        }
    }

    private static void loadStudentsFromFile() {
        System.out.print("Enter filename to load students: ");
        String filename = scanner.next();

        try {
            ArrayList<Student> students = FileHandler.readStudentsFromFile(filename);
            portal.getStudents().addAll(students);
            System.out.println("Students loaded from file successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    private static void loadCoursesFromFile() {
        System.out.print("Enter filename to load courses: ");
        String filename = scanner.next();

        try {
            ArrayList<Course> courses = FileHandler.readCoursesFromFile(filename);
            portal.getCourses().addAll(courses);
            System.out.println("Courses loaded from file successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
