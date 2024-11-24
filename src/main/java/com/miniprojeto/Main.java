package com.miniprojeto;

import com.miniprojeto.Controller.*;
import com.miniprojeto.Services.*;
import com.miniprojeto.View.LibraryView;
import com.miniprojeto.View.Menu;
import com.miniprojeto.View.StudentView;
import com.miniprojeto.View.SubjectView;

public class Main {
    public static void main(String[] args) {
        IStudentService studentService = new StudentService();
        ISubjectService subjectService = new SubjectService();
        ILibraryService libraryService = new LibraryService();

        EnrollmentService enrollmentService = new EnrollmentService(studentService, subjectService);
        ReservationService reservationService = new ReservationService(studentService, libraryService);

        StudentController studentController = new StudentController(studentService);
        SubjectController subjectController = new SubjectController(subjectService);
        LibraryController libraryController = new LibraryController(libraryService);

        EnrollmentController enrollmentController = new EnrollmentController(enrollmentService);
        ReservationController reservationController = new ReservationController(reservationService);

        StudentView studentView = new StudentView(studentController);
        SubjectView subjectView = new SubjectView(subjectController, enrollmentController);
        LibraryView libraryView = new LibraryView(libraryController, reservationController);

        MenuController menuController = new MenuController(studentView, subjectView, libraryView);
        Menu menu = new Menu(menuController);

        menu.start();
    }
}