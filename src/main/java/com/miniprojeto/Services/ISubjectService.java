package com.miniprojeto.Services;

import com.miniprojeto.Model.Subject;

import java.util.List;

public interface ISubjectService {

    void loadAllSubjects();
    List<Subject> getAllSubjects();
    List<Subject> getSubjectsById(int id);
    List<Subject> getSubjectsByName(String name);

}
