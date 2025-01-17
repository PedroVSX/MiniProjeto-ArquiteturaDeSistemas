package com.miniprojeto.Services;

import com.miniprojeto.Model.Student;
import com.miniprojeto.Model.Subject;

public class EnrollmentService {

    private final IStudentService studentService;
    private final ISubjectService subjectService;

    public EnrollmentService(IStudentService studentService, ISubjectService subjectService) {
        this.studentService = studentService;
        this.subjectService = subjectService;
    }

    public boolean enrollStudentInSubject(int studentId, int subjectId) {
        Student student = studentService.getStudentsById(studentId).getFirst();
        Subject subject = subjectService.getSubjectsById(subjectId).getFirst();

        if (student.isActive() && !student.getEnrolledSubjects().contains(subject)) {
            student.getEnrolledSubjects().add(subject);
            return true;
        }

        return false;
    }

    public boolean unenrollStudentInSubject(int studentId, int subjectId) {
        Student student = studentService.getStudentsById(studentId).getFirst();
        Subject subject = subjectService.getSubjectsById(subjectId).getFirst();

        if (student.isActive() && student.getEnrolledSubjects().contains(subject)) {
            student.getEnrolledSubjects().remove(subject);
            return true;
        }

        return false;
    }

}
