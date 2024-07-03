package studentmanagement.controller;

import java.util.List;
import studentmanagement.model.Enrollment;
import studentmanagement.view.EnrollmentView;

public class EnrollmentController {
    private EnrollmentView enrollmentView;

    public EnrollmentController(EnrollmentView enrollmentView) {
        this.enrollmentView = enrollmentView;
    }

    public void addEnrollment(Enrollment enrollment) {
        Enrollment.addEnrollment(enrollment);
    }

    public void updateEnrollment(Enrollment enrollment) {
        Enrollment.updateEnrollment(enrollment);
    }

    public void deleteEnrollment(int enrollmentId) {
        Enrollment.deleteEnrollment(enrollmentId);
    }

    public void viewEnrollment(int enrollmentId) {
        enrollmentView.showEnrollment(Enrollment.getEnrollmentById(enrollmentId));
    }

    public void viewAllEnrollments() {
        enrollmentView.showAllEnrollments(Enrollment.getAllEnrollments());
    }
}

