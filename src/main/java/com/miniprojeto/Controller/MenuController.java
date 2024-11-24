package com.miniprojeto.Controller;

import com.miniprojeto.View.LibraryView;
import com.miniprojeto.View.StudentView;
import com.miniprojeto.View.SubjectView;

public class MenuController {

    private final StudentView studentView;
    private final SubjectView subjectView;
    private final LibraryView libraryView;

    public MenuController(StudentView studentView, SubjectView subjectView, LibraryView libraryView) {
        this.studentView = studentView;
        this.subjectView = subjectView;
        this.libraryView = libraryView;
    }

    public void selection(int choice) {
        switch (choice) {
            case 0 -> System.out.println("Saindo da aplicação...");
            case 1 -> studentView.getAllStudents();
            case 2 -> subjectView.getAllSubjects();
            case 3 -> libraryView.getAllBooks();
            case 4 -> studentView.searchStudentById();
            case 5 -> studentView.searchStudentByName();
            case 6 -> studentView.searchStudentByCourse();
            case 7 -> studentView.searchStudentByModality();
            case 8 -> studentView.searchStudentByCourseAndModality();
            case 9 -> studentView.getStudentEnrolledSubjects();
            case 10 -> studentView.getStudentReservedBooks();
            case 11 -> subjectView.searchSubjectById();
            case 12 -> subjectView.searchSubjectByName();
            case 13 -> subjectView.enrollStudentInSubject();
            case 14 -> subjectView.unenrollStudentInSubject();
            case 15 -> libraryView.searchBookById();
            case 16 -> libraryView.searchBookByName();
            case 17 -> libraryView.reserveBookToStudent();
            case 18 -> libraryView.cancelStudentBookReservation();
            default -> System.out.println("Opção inválida! Tente novamente.");
        }
    }
}