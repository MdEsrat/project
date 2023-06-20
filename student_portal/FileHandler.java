import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
class FileHandler {
    public static ArrayList<Student> readStudentsFromFile(String filename) throws FileNotFoundException {
        ArrayList<Student> students = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                int studentId = Integer.parseInt(data[0]);
                String name = data[1];
                String email = data[2];

                Student student = new UndergraduateStudent(studentId, name, email);
                students.add(student);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw e;
        }
        return students;
    }

    public static ArrayList<Course> readCoursesFromFile(String filename) throws FileNotFoundException {
        ArrayList<Course> courses = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                int courseId = Integer.parseInt(data[0]);
                String title = data[1];
                String instructor = data[2];
                int credits = Integer.parseInt(data[3]);

                Course course = new Course(courseId, title, instructor, credits);
                courses.add(course);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw e;
        }
        return courses;
    }

    public static void writeStudentsToFile(ArrayList<Student> students, String filename) throws IOException {
        try {
            FileWriter writer = new FileWriter(filename);

            for (Student student : students) {
                writer.write(student.getStudentId() + "," + student.getName() + "," + student.getEmail() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw e;
        }
    }

    public static void writeCoursesToFile(ArrayList<Course> courses, String filename) throws IOException {
        try {
            FileWriter writer = new FileWriter(filename);

            for (Course course : courses) {
                writer.write(course.getCourseId() + "," + course.getTitle() + "," + course.getInstructor() + "," + course.getCredits() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw e;
        }
    }
}
