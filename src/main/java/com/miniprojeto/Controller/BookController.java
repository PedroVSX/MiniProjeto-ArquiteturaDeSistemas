package com.miniprojeto.Controller;

import com.miniprojeto.Model.Book;
import com.miniprojeto.Model.Student;
import com.miniprojeto.Services.BookService;
import com.miniprojeto.Services.LibraryService;
import com.miniprojeto.Services.StudentService;
import com.miniprojeto.View.BookView;
import com.miniprojeto.View.StudentView;
import com.miniprojeto.View.SubjectView;

public class BookController {

    private final BookView view;
    private final BookService service;
    private final StudentView studentView;
    private final StudentService studentService;
    private final LibraryService libraryService;

    public BookController(BookService service, StudentView studentView, StudentService studentService, LibraryService libraryService) {
        this.service = service;
        this.view = new BookView(this);
        this.studentView = studentView;
        this.studentService = studentService;
        this.libraryService = libraryService;
        service.loadAllBooks();
    }

    public void reserveBookForStudent(int studentId, int bookId) {
        Student student = studentService.getAllStudents().get(studentId - 1);
        Book book = service.getAllBooks().get(bookId - 1);

        boolean success = libraryService.reserveBook(student, book);

        if (success) {
            view.reservationSuccess();
        } else {
            view.reservationError();
        }
    }

    public void cancelStudentBookReservation(int studentId, int bookId) {
        Student student = studentService.getAllStudents().get(studentId - 1);
        Book book = service.getAllBooks().get(bookId - 1);

        boolean success = libraryService.cancelReservation(student, book);

        if (success) {
            view.reservationCancelSuccess();
        } else {
            view.reservationCancelError();
        }
    }

    public void displayAllBooks() {
        view.displayBooks(service.getAllBooks());
    }

    public void displayAllStudents() {
        studentView.displayStudents(studentService.getAllStudents());
    }
}
