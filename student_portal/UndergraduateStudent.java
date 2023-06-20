public class UndergraduateStudent extends Student {
    public UndergraduateStudent(int studentId, String name, String email) {
        super(studentId, name, email);
    }

    @Override
    public void displayInfo() {
        System.out.println("Undergraduate Student");
        System.out.println("ID: " + getStudentId());
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Courses: " + getCourses());
        System.out.println("--------------------");
    }
}
