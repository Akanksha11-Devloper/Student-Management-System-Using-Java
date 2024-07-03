package studentmanagement.controller;

import java.util.List;
import studentmanagement.model.Course;
import studentmanagement.view.CourseView;

public class CourseController {
    private CourseView courseView;

    public CourseController(CourseView courseView) {
        this.courseView = courseView;
    }

    public void addCourse(Course course) {
        Course.addCourse(course);
    }

    public void updateCourse(Course course) {
        Course.updateCourse(course);
    }

    public void deleteCourse(int courseId) {
        Course.deleteCourse(courseId);
    }

    public void viewCourse(int courseId) {
        courseView.showCourse(Course.getCourseById(courseId));
    }

    public void viewAllCourses() {
        courseView.showAllCourses(Course.getAllCourses());
    }
}

