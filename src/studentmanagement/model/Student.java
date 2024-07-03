package studentmanagement.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Student {
    private int id;
    private String name;
    private Date dob;
    private String email;
    private String phone;

    
    private static List<Student> students = new ArrayList<>();

    public Student(int id, String name, Date dob, String email, String phone) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

   
    public static void addStudent(Student student) {
        Optional.ofNullable(student)
                .ifPresentOrElse(
                        s -> students.add(s),
                        () -> System.out.println("Cannot add null student.")
                );
    }

    public static void updateStudent(Student student) {
        students.stream()
                .filter(s -> s.getId() == student.getId())
                .findFirst()
                .ifPresentOrElse(
                        s -> students.set(students.indexOf(s), student),
                        () -> System.out.println("Student not found with ID: " + student.getId())
                );
    }


    public static void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public static Student getStudentById(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }


    public static List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
}

