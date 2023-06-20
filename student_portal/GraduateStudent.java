
public class GraduateStudent extends Student {
    public GraduateStudent(int studentId, String name, String email) {
        super(studentId, name, email);
    }

    @Override
    public void displayInfo() {
        System.out.println("Graduate Student");
        System.out.println("ID: " + getStudentId());
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Courses: " + getCourses());
        System.out.println("--------------------");
    }
}
