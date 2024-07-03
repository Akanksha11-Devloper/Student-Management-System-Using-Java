import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import studentmanagement.controller.CourseController;
import studentmanagement.controller.EnrollmentController;
import studentmanagement.controller.StudentController;
import studentmanagement.model.Course;
import studentmanagement.model.Enrollment;
import studentmanagement.model.Student;
import studentmanagement.view.CourseView;
import studentmanagement.view.EnrollmentView;
import studentmanagement.view.StudentView;

public class Main {
    public static void main(String[] args) {
        
        StudentView studentView = new StudentView();
        CourseView courseView = new CourseView();
        EnrollmentView enrollmentView = new EnrollmentView();

        
        StudentController studentController = new StudentController(studentView);
        CourseController courseController = new CourseController(courseView);
        EnrollmentController enrollmentController = new EnrollmentController(enrollmentView);

        
        Scanner scanner = new Scanner(System.in);

       
        try {
            System.out.println("Enter student details:");
            Student student = studentView.getStudentDetails(scanner);
            studentController.addStudent(student);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input format for student details.");
            scanner.nextLine(); 
        }

        try {
            System.out.println("Enter course details:");
            Course course = courseView.getCourseDetails(scanner);
            courseController.addCourse(course);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input format for course details.");
            scanner.nextLine();
        }

        try {
            System.out.println("Enter enrollment details:");
            Enrollment enrollment = enrollmentView.getEnrollmentDetails(scanner);
            enrollmentController.addEnrollment(enrollment);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input format for enrollment details.");
            scanner.nextLine(); 
        }

        
        studentController.viewAllStudents();
        courseController.viewAllCourses();
        enrollmentController.viewAllEnrollments();

        
        scanner.close();
    }
}
