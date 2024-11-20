package com.miniprojeto;

import com.miniprojeto.Controller.BookController;
import com.miniprojeto.Controller.StudentController;
import com.miniprojeto.Controller.SubjectController;
import com.miniprojeto.Services.*;
import com.miniprojeto.View.BookView;
import com.miniprojeto.View.StudentView;
import com.miniprojeto.View.SubjectView;

public class Main {
    public static void main(String[] args) {
        EnrollmentService enrollmentService = new EnrollmentService();
        LibraryService libraryService = new LibraryService();

        StudentService studentService = new StudentService();
        StudentController studentController = new StudentController(studentService);
        StudentView studentView = new StudentView(studentController);

        SubjectService subjectService = new SubjectService();
        SubjectController subjectController = new SubjectController(subjectService, studentService, studentView, enrollmentService);
        SubjectView subjectView = new SubjectView(subjectController);

        BookService bookService = new BookService();
        BookController bookController = new BookController(bookService, studentView, studentService, libraryService);
        BookView bookView = new BookView(bookController);
    }
}