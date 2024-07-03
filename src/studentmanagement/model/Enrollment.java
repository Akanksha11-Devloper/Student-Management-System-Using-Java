package studentmanagement.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Enrollment {
    private int enrollmentId;
    private int studentId;
    private int courseId;
    private Date enrollmentDate;
    private String grade;

    
    private static List<Enrollment> enrollments = new ArrayList<>();

    public Enrollment(int enrollmentId, int studentId, int courseId, Date enrollmentDate, String grade) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.grade = grade;
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "enrollmentId=" + enrollmentId +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", enrollmentDate=" + enrollmentDate +
                ", grade='" + grade + '\'' +
                '}';
    }

    
    public static void addEnrollment(Enrollment enrollment) {
        boolean exists = enrollments.stream()
                                    .anyMatch(e -> e.getStudentId() == enrollment.getStudentId() && e.getCourseId() == enrollment.getCourseId());
        if (!exists) {
            enrollments.add(enrollment);
            System.out.println("Enrollment added successfully.");
        } else {
            System.out.println("Enrollment already exists for this student and course.");
        }
    }



    public static void updateEnrollment(Enrollment enrollment) {
        enrollments.stream()
                   .filter(e -> e.getEnrollmentId() == enrollment.getEnrollmentId())
                   .findFirst()
                   .ifPresent(e -> enrollments.set(enrollments.indexOf(e), enrollment));
    }


    public static void deleteEnrollment(int enrollmentId) {
        enrollments.removeIf(enrollment -> enrollment.getEnrollmentId() == enrollmentId);
    }

    public static Enrollment getEnrollmentById(int enrollmentId) {
        return enrollments.stream()
                         .filter(enrollment -> enrollment.getEnrollmentId() == enrollmentId)
                         .findFirst()
                         .orElse(null);
    }


    public static List<Enrollment> getAllEnrollments() {
        return new ArrayList<>(enrollments);
    }
}
