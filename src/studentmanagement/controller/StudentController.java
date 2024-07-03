package studentmanagement.controller;


import java.util.List;
import studentmanagement.model.Student;
import studentmanagement.view.StudentView;

public class StudentController {
    private StudentView studentView;

    public StudentController(StudentView studentView) {
        this.studentView = studentView;
    }

    public void addStudent(Student student) {
        Student.addStudent(student);
    }

    public void updateStudent(Student student) {
        Student.updateStudent(student);
    }

    public void deleteStudent(int id) {
        Student.deleteStudent(id);
    }

    public void viewStudent(int id) {
        studentView.showStudent(Student.getStudentById(id));
    }

    public void viewAllStudents() {
        studentView.showAllStudents(Student.getAllStudents());
    }
}
