package studentmanagement.view;

import java.util.List;
import java.util.Scanner;

import studentmanagement.model.Student;

public class StudentView {

    private final Scanner scanner;

    public StudentView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayStudentMenu() {
        System.out.println("===== Student Menu =====");
        System.out.println("1. Get Student Details");
        System.out.println("2. Show All Students");
        System.out.println("3. Exit");
        System.out.println("========================");
    }

    
    public Student getStudentDetails(Scanner scanner2) {
        System.out.println("Enter student ID:");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Enter student name:");
        String name = scanner.nextLine();
        System.out.println("Enter student date of birth (YYYY-MM-DD):");
        String dobStr = scanner.nextLine();
        System.out.println("Enter student email:");
        String email = scanner.nextLine();
        System.out.println("Enter student phone:");
        String phone = scanner.nextLine();

       
        return new Student(id, name, null, email, phone); 
    }

    
    public void showStudent(Student student) {
        if (student != null) {
            System.out.println("===== Student Details =====");
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("DOB: " + student.getDob()); 
            System.out.println("Email: " + student.getEmail());
            System.out.println("Phone: " + student.getPhone());
            System.out.println("============================");
        } else {
            System.out.println("Student details not found.");
        }
    }

    
    public void showAllStudents(List<Student> students) {
        System.out.println("===== All Students =====");
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student student : students) {
                showStudent(student);
            }
        }
        System.out.println("========================");
    }

   
    public void showMessage(String message) {
        System.out.println(message);
    }

	
}
