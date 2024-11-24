package com.miniprojeto.Services;

import com.miniprojeto.Model.Book;
import com.miniprojeto.Model.Student;
import com.miniprojeto.Model.Subject;

import java.util.List;

public interface IStudentService {

    void loadAllStudents();
    List<Student> getAllStudents();
    List<Student> getStudentsByCourseAndModality(String course, String modality);
    List<Student> getStudentsByCourse(String course);
    List<Student> getStudentsByModality(String modality);
    List<Student> getStudentsByName(String name);
    List<Student> getStudentsById(int id);
    List<Subject> getSubjectsByStudentId(int id);
    List<Book> getBooksByStudentId(int id);

}
