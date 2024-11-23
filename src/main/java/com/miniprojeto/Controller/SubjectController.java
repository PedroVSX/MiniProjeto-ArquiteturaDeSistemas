package com.miniprojeto.Controller;


import com.miniprojeto.Iterator.ModelIterator;
import com.miniprojeto.Iterator.SubjectIterator;
import com.miniprojeto.Model.Subject;
import com.miniprojeto.Services.SubjectService;

import java.util.List;

public class SubjectController {

    private final SubjectService service;

    public SubjectController(SubjectService service) {
        this.service = service;
    }

    public String getAllSubjects() {
        return subjectIterator(service.getAllSubjects());
    }

    public String getSubjectById(int id) {
        List<Subject> subjects = service.getSubjectsById(id);

        if (!subjects.isEmpty()) {
            return subjectIterator(subjects);
        }

        return "Nenhuma disciplina foi encontrada!";
    }

    public String getSubjectByName(String name) {
        List<Subject> subjects = service.getSubjectsByName(name);

        if (!subjects.isEmpty()) {
            return subjectIterator(subjects);
        }

        return "Nenhuma disciplina foi encontrada!";
    }

    public String subjectIterator(List<Subject> subjectList) {
        ModelIterator<Subject> iterator = new SubjectIterator(subjectList);
        String s = "";

        s += iterator.getNext().toString() + "\n";

        return s;
    }

}
