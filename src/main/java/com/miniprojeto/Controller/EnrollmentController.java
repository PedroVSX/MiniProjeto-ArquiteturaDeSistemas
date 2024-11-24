package com.miniprojeto.Controller;

import com.miniprojeto.Services.EnrollmentService;

public class EnrollmentController {

    private final EnrollmentService service;

    public EnrollmentController(EnrollmentService service) {
        this.service = service;
    }

    public String enrollStudent(int studentId, int subjectId) {
        if (service.enrollStudentInSubject(studentId, subjectId)) {
            return "Estudante matriculado com sucesso!";
        }

        return "Não foi possível matricular o estudante!";
    }

    public String unenrollStudent(int studentId, int subjectId) {
        if (service.unenrollStudentInSubject(studentId, subjectId)) {
            return "Estudante desmatriculado com sucesso!";
        }

        return "Não foi possível desmatricular o estudante!";
    }

}
