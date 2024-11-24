package com.miniprojeto.Services;

import com.miniprojeto.Model.Book;
import com.miniprojeto.Model.Student;

public class ReservationService {

    private final IStudentService studentService;
    private final ILibraryService libraryService;

    public ReservationService(IStudentService studentService, ILibraryService libraryService) {
        this.studentService = studentService;
        this.libraryService = libraryService;
    }

    public boolean reserveBookToStudent(int studentId, int bookId) {
        Student student = studentService.getStudentsById(studentId).getFirst();
        Book book = libraryService.getBooksById(bookId).getFirst();

        boolean studentConditions = student.isActive() && !student.getReservedBooks().contains(book);

        if (studentConditions && book.isAvailable()) {
            student.getReservedBooks().add(book);
            book.setStatus(false);
            return true;
        }

        return false;
    }

    public boolean cancelStudentBookReservation(int studentId, int bookId) {
        Student student = studentService.getStudentsById(studentId).getFirst();
        Book book = libraryService.getBooksById(bookId).getFirst();

        boolean studentConditions = student.isActive() && student.getReservedBooks().contains(book);

        if (studentConditions && !book.isAvailable()) {
            student.getReservedBooks().remove(book);
            book.setStatus(true);
            return true;
        }

        return false;
    }

}
