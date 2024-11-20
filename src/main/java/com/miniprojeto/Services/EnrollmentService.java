package com.miniprojeto.Services;

import com.miniprojeto.Model.Student;
import com.miniprojeto.Model.Subject;

public class EnrollmentService {

    public boolean enroll(Student student, Subject subject) {
        if (student.isActive() && !student.getEnrolledSubjects().contains(subject)) {
            student.addSubject(subject);
            return true;
        }
        return false;
    }

    public boolean unenroll(Student student, int subjectId) {
        return student.removeSubjectById(subjectId);
    }

}
