package com.miniprojeto.Controller;

import com.miniprojeto.Services.StudentService;
import com.miniprojeto.Model.Student;
import com.miniprojeto.View.StudentView;
import java.util.List;

public class StudentController {

    private final StudentService service;
    private StudentView view;

    public StudentController(StudentService service) {
        this.service = service;
        this.view = new StudentView(this);
        service.loadAllStudents();
    }

    public void searchStudentsByCourse(String course) {
        List<Student> list = service.getAllStudents().stream()
                .filter(student -> course.equalsIgnoreCase(student.getCourse()))
                .toList();

        view.displayStudents(list);
    }

    public void searchStudentsByModality(boolean modality) {
        List<Student> list =  service.getAllStudents().stream()
                .filter(student -> modality == student.getModality())
                .toList();

        view.displayStudents(list);
    }

    public void searchStudentsByCourseAndModality(String course, boolean modality) {
        List<Student> list = service.getAllStudents().stream()
                .filter(student -> course.equalsIgnoreCase(student.getCourse()) && modality == student.getModality())
                .toList();

        view.displayStudents(list);
    }

    public void searchStudentsById(int id) {
        List<Student> list = service.getAllStudents().stream()
                .filter(student -> id == student.getId())
                .toList();

        view.displayStudents(list);
    }

    public void searchStudentsByName(String name) {
        List<Student> list = service.getAllStudents().stream()
                .filter(student -> name.equalsIgnoreCase(student.getName()))
                .toList();

        view.displayStudents(list);
    }

    public void displayAllStudents() {
        view.displayStudents(service.getAllStudents());
    }
}
