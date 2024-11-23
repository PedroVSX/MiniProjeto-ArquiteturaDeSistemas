package com.miniprojeto.Controller;

import com.miniprojeto.Iterator.ModelIterator;
import com.miniprojeto.Iterator.StudentIterator;
import com.miniprojeto.Iterator.SubjectIterator;
import com.miniprojeto.Model.Student;
import com.miniprojeto.Model.Subject;
import com.miniprojeto.Services.StudentService;

import java.util.List;

public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    public String getAllStudents() {
        return studentIterator(service.getAllStudents());
    }

    public String searchByCourse(String course) {
        List<Student> students = service.getStudentsByCourse(course);

        if (!students.isEmpty()) {
            return studentIterator(students);
        }

        return "Nenhum estudante foi encontrado!";
    }

    public String searchByModality(String modality) {
        List<Student> students = service.getStudentsByModality(modality);

        if (!students.isEmpty()) {
            return studentIterator(students);
        }

        return "Nenhum estudante foi encontrado!";
    }

    public String searchByCorseAndModality(String course, String modality) {
        List<Student> students = service.getStudentsByCourseAndModality(course, modality);

        if (!students.isEmpty()) {
            return studentIterator(students);
        }

        return "Nenhum estudante foi encontrado!";
    }

    public String searchById(int id) {
        List<Student> students = service.getStudentsById(id);

        if (!students.isEmpty()) {
            return studentIterator(students);
        }

        return "Nenhum estudante foi encontrado!";
    }

    public String searchByName(String name) {
        List<Student> students = service.getStudentsByName(name);

        if (!students.isEmpty()) {
            return studentIterator(students);
        }

        return "Nenhum estudante foi encontrado!";
    }

    public String getStudentSubjects(int id) {
        List<Subject> subjects = service.getSubjectsByStudentId(id);

        if (!subjects.isEmpty()) {
            ModelIterator<Subject> iterator = new SubjectIterator(subjects);
            String s = "";

            s += iterator.getNext().toString() + "\n";

            return s;
        }

        return "Estudante não está matriculado em nenhuma disciplina!";
    }

    private String studentIterator(List<Student> studentList) {
        ModelIterator<Student> iterator = new StudentIterator(studentList);
        String s = "";

        s += iterator.getNext().toString() + "\n";

        return s;
    }

}
