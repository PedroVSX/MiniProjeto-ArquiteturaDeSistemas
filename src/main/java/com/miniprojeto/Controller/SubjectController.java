package com.miniprojeto.Controller;

import com.miniprojeto.Microservices.SubjectService;
import com.miniprojeto.Model.Student;
import com.miniprojeto.Model.Subject;
import com.miniprojeto.View.StudentView;
import com.miniprojeto.View.SubjectView;

import java.util.List;

public class SubjectController {

    private final SubjectService service;
    private final SubjectView view;
    private final StudentView studentView;
    private final StudentController studentController;

    public SubjectController(SubjectService service, StudentController studentController, StudentView studentView) {
        this.service = service;
        this.view = new SubjectView(this);
        this.studentView = studentView;
        this.studentController = studentController;
        service.loadAllSubjects();
    }

    public void enrollStudentInSubject(int studentId, int subjectId) {
        Student student = studentController.getStudentById(studentId);
        Subject subject = service.getAllSubjects().get(subjectId - 1);

        if (student.isActive() && !student.getEnrolledSubjects().contains(subject)) {
            student.getEnrolledSubjects().add(subject);
        }

        view.enrollmentSuccess();
    }

    public void unenrollStudentFromSubject(int studentId, int subjectId) {
        Student student = studentController.getStudentById(studentId);

        boolean removed = student.getEnrolledSubjects().removeIf(subject -> subject.getId() == subjectId);

        view.unenrollmentSuccess();
    }

    public void listStudentEnrolledSubjects(int studentId) {
        Student student = studentController.getStudentById(studentId);

        List<Subject> enrolledSubjects = student.getEnrolledSubjects();

        if (!enrolledSubjects.isEmpty()) {
            view.displaySubjects(enrolledSubjects);
        }
    }

    public void displayAllSubjects() {
        view.displaySubjects(service.getAllSubjects());
    }

    public StudentView getStudentView() {
        return studentView;
    }
}
