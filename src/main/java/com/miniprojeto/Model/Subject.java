package com.miniprojeto.Model;

public class Subject {

    private int id;
    private String course;
    private String name;

    public Subject(int id, String course, String name) {
        this.id = id;
        this.course = course;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Id: " + id +
                "\nCurso: " + course +
                "\nNome: " + name;
    }

    public String toStringCourseAndName() {
        return name + " (" + course + ")";
    }
}
