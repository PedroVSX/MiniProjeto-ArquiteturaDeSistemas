package com.miniprojeto;

import com.miniprojeto.Controller.StudentController;
import com.miniprojeto.Controller.SubjectController;
import com.miniprojeto.Microservices.StudentService;
import com.miniprojeto.Microservices.SubjectService;
import com.miniprojeto.View.StudentView;
import com.miniprojeto.View.SubjectView;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        StudentController studentController = new StudentController(studentService);
        StudentView studentView = new StudentView(studentController);

        SubjectService subjectService = new SubjectService();
        SubjectController subjectController = new SubjectController(subjectService, studentController, studentView);
        SubjectView subjectView = new SubjectView(subjectController);

        subjectView.enrollStudent();

        studentView.displayAllStudents();
    }
}