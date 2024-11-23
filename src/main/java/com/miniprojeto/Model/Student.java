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
    private List<Book> reservedBooks;

    public Student(int id, String name, String course, boolean modality, boolean status) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.modality = modality;
        this.status = status;
        this.enrolledSubjects = new ArrayList<>();
        this.reservedBooks = new ArrayList<>();
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

    public List<Book> getReservedBooks() {
        return reservedBooks;
    }

    @Override
    public String toString() {
        return "Id: " + id +
                "\nNome: " + name +
                "\nCurso: " + course +
                "\nModalidade: " + (modality ? "EAD" : "Presencial") +
                "\nStatus: " + (status ? "Ativo" : "Trancado");
    }

}
