package com.miniprojeto.Controller;

import com.miniprojeto.Services.EnrollmentService;
import com.miniprojeto.Services.StudentService;
import com.miniprojeto.Services.SubjectService;
import com.miniprojeto.Model.Student;
import com.miniprojeto.Model.Subject;
import com.miniprojeto.View.StudentView;
import com.miniprojeto.View.SubjectView;

import java.util.List;

public class SubjectController {

    private final SubjectService service;
    private final SubjectView view;
    private final StudentService studentService;
    private final StudentView studentView;
    private final EnrollmentService enrollmentService;

    public SubjectController(SubjectService service, StudentService studentService, StudentView studentView, EnrollmentService enrollmentService) {
        this.service = service;
        this.view = new SubjectView(this);
        this.studentService = studentService;
        this.studentView = studentView;
        this.enrollmentService = enrollmentService;
        service.loadAllSubjects();
    }

    public void enrollStudentInSubject(int studentId, int subjectId) {
        Student student = studentService.getAllStudents().get(studentId - 1);
        Subject subject = service.getAllSubjects().get(subjectId - 1);

        boolean success = enrollmentService.enroll(student, subject);

        if (success) {
            view.enrollmentSuccess();
        } else {
            view.enrollmentError();
        }
    }

    public void unenrollStudentFromSubject(int studentId, int subjectId) {
        Student student = studentService.getAllStudents().get(studentId - 1);

        boolean success = enrollmentService.unenroll(student, subjectId);

        if (success) {
            view.unenrollmentSuccess();
        } else {
            view.unenrollmentError();
        }
    }

    public void displayAllSubjects() {
        view.displaySubjects(service.getAllSubjects());
    }

    public void displayAllStudents() {
        studentView.displayStudents(studentService.getAllStudents());
    }

}
