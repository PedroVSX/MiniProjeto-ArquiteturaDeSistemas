package com.miniprojeto.Model;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private int id;
    private String name;
    private String course;
    private boolean modality; // 0: Presencial | 1: EAD
    private boolean status; // 0: Trancado | 1: Ativo
    private List<Subject> enrolledSubjects;

    public Student(int id, String name, String course, boolean modality, boolean status) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.modality = modality;
        this.status = status;
        this.enrolledSubjects = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public boolean getModality() {
        return modality;
    }

    public boolean isActive() {
        return status;
    }

    public List<Subject> getEnrolledSubjects() {
        return enrolledSubjects;
    }

    public void addSubject(Subject subject) {
        if (!enrolledSubjects.contains(subject)) {
            enrolledSubjects.add(subject);
        }
    }

    public boolean removeSubjectById(int subjectId) {
        return enrolledSubjects.removeIf(subject -> subject.getId() == subjectId);
    }

    @Override
    public String toString() {
        String subjects = "";
        for (int i = 0; i < enrolledSubjects.size(); i++) {
            if (i == enrolledSubjects.size() - 1) {
                subjects += enrolledSubjects.get(i).toStringCourseAndName();
            } else {
                subjects += enrolledSubjects.get(i).toStringCourseAndName() + ", ";
            }
        }

        return "Id: " + id +
                "\nNome: " + name +
                "\nCurso: " + course +
                "\nModalidade: " + (modality ? "EAD" : "Presencial") +
                "\nStatus: " + (status ? "Ativo" : "Trancado") +
                "\nDisciplinas Matriculadas: " + (enrolledSubjects.isEmpty() ? "Nenhuma" : subjects);
    }

}
