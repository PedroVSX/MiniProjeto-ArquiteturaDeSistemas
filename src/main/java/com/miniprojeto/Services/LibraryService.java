package com.miniprojeto.Services;

import com.miniprojeto.Model.Book;
import com.miniprojeto.Model.Student;

public class LibraryService {

    public boolean reserveBook(Student student, Book book) {
        if (student.isActive()) {

            return true;
        }

        return false;
    }

    public boolean cancelReservation(Student student, Book book) {
        return false;
    }

}
