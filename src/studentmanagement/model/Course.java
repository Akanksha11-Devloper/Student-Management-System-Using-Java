package studentmanagement.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Course {
    private int courseId;
    private String courseName;
    private String courseDescription;
    private int credits;

   
    private static List<Course> courses = new ArrayList<>();

    public Course(int courseId, String courseName, String courseDescription, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.credits = credits;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", credits=" + credits +
                '}';
    }

   
    public static void addCourse(Course course) {
        Optional.ofNullable(course)
                .ifPresentOrElse(
                        c -> courses.add(c),
                        () -> System.out.println("Cannot add null course.")
                );
    }



    public static void updateCourse(Course course) {
        courses.stream()
                .filter(c -> c.getCourseId() == course.getCourseId())
                .findFirst()
                .ifPresentOrElse(
                        c -> courses.set(courses.indexOf(c), course),
                        () -> System.out.println("Course not found with ID: " + course.getCourseId())
                );
    }


    public static void deleteCourse(int courseId) {
        courses.removeIf(course -> course.getCourseId() == courseId);
    }


    public static Course getCourseById(int courseId) {
        return courses.stream()
                .filter(course -> course.getCourseId() == courseId)
                .findFirst()
                .orElse(null);
    }


    public static List<Course> getAllCourses() {
        return new ArrayList<>(courses);
    }
}

