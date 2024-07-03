package studentmanagement.view;

import java.util.List;
import java.util.Scanner;

import studentmanagement.model.Enrollment;

public class EnrollmentView {

    private final Scanner scanner;

    public EnrollmentView() {
        this.scanner = new Scanner(System.in);
    }

   
    public void displayEnrollmentMenu() {
        System.out.println("===== Enrollment Menu =====");
        System.out.println("1. Get Enrollment Details");
        System.out.println("2. Show All Enrollments");
        System.out.println("3. Exit");
        System.out.println("============================");
    }

    
    public Enrollment getEnrollmentDetails(Scanner scanner2) {
        System.out.println("Enter enrollment ID:");
        int id = scanner.nextInt();
        System.out.println("Enter student ID:");
        int studentId = scanner.nextInt();
        System.out.println("Enter course ID:");
        int courseId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Enter grade:");
        String grade = scanner.nextLine();

       
        return new Enrollment(id, studentId, courseId, null, grade); 
    }

    
    public void showEnrollment(Enrollment enrollment) {
        if (enrollment != null) {
            System.out.println("===== Enrollment Details =====");
            System.out.println("ID: " + enrollment.getEnrollmentId());
            System.out.println("Student ID: " + enrollment.getStudentId());
            System.out.println("Course ID: " + enrollment.getCourseId());
            System.out.println("Enrollment Date: " + enrollment.getEnrollmentDate()); 
            System.out.println("Grade: " + enrollment.getGrade());
            System.out.println("==============================");
        } else {
            System.out.println("Enrollment details not found.");
        }
    }

    
    public void showAllEnrollments(List<Enrollment> enrollments) {
        System.out.println("===== All Enrollments =====");
        if (enrollments.isEmpty()) {
            System.out.println("No enrollments to display.");
        } else {
            for (Enrollment enrollment : enrollments) {
                showEnrollment(enrollment);
            }
        }
        System.out.println("============================");
    }

   
    public void showMessage(String message) {
        System.out.println(message);
    }
}
