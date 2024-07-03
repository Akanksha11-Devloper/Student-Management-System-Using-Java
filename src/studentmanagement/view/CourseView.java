package studentmanagement.view;

import java.util.List;
import java.util.Scanner;

import studentmanagement.model.Course;

public class CourseView {

    private final Scanner scanner;

    public CourseView() {
        this.scanner = new Scanner(System.in);
    }

    
    public void displayCourseMenu() {
        System.out.println("===== Course Menu =====");
        System.out.println("1. Get Course Details");
        System.out.println("2. Show All Courses");
        System.out.println("3. Exit");
        System.out.println("========================");
    }

    
    public Course getCourseDetails(Scanner scanner2) {
        System.out.println("Enter course ID:");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Enter course name:");
        String name = scanner.nextLine();
        System.out.println("Enter course description:");
        String description = scanner.nextLine();
        System.out.println("Enter course credits:");
        int credits = scanner.nextInt();
        scanner.nextLine(); 

        
        return new Course(id, name, description, credits);
    }

    
    public void showCourse(Course course) {
        if (course != null) {
            System.out.println("===== Course Details =====");
            System.out.println("ID: " + course.getCourseId());
            System.out.println("Name: " + course.getCourseName());
            System.out.println("Description: " + course.getCourseDescription());
            System.out.println("Credits: " + course.getCredits());
            System.out.println("============================");
        } else {
            System.out.println("Course details not found.");
        }
    }

    
    public void showAllCourses(List<Course> courses) {
        System.out.println("===== All Courses =====");
        if (courses.isEmpty()) {
            System.out.println("No courses to display.");
        } else {
            for (Course course : courses) {
                showCourse(course);
            }
        }
        System.out.println("========================");
    }

    
    public void showMessage(String message) {
        System.out.println(message);
    }
}

