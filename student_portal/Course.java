public class Course {
    private int courseId;
    private String title;
    private String instructor;
    private int credits;

    public Course(int courseId, String title, String instructor, int credits) {
        this.courseId = courseId;
        this.title = title;
        this.instructor = instructor;
        this.credits = credits;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public String getInstructor() {
        return instructor;
    }

    public int getCredits() {
        return credits;
    }
}
