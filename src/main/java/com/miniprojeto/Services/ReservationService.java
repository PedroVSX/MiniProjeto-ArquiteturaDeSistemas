package com.miniprojeto.Services;

import com.miniprojeto.Model.Book;
import com.miniprojeto.Model.Student;

public class ReservationService {

    private final StudentService studentService;
    private final LibraryService libraryService;

    public ReservationService(StudentService studentService, LibraryService libraryService) {
        this.studentService = studentService;
        this.libraryService = libraryService;
    }

    public boolean reserveBookToStudent(int studentId, int bookId) {
        Student student = studentService.getStudentsById(studentId).getFirst();
        Book book = libraryService.getBooksById(bookId).getFirst();

        if (!student.getReservedBooks().contains(book)) {
            student.getReservedBooks().add(book);
            return true;
        }

        return false;
    }

    public boolean cancelStudentBookReservation(int studentId, int bookId) {
        Student student = studentService.getStudentsById(studentId).getFirst();
        Book book = libraryService.getBooksById(bookId).getFirst();

        if (student.getReservedBooks().contains(book)) {
            student.getReservedBooks().remove(book);
            return true;
        }

        return false;
    }

}
