package com.miniprojeto.Controller;

import com.miniprojeto.Services.ReservationService;

public class ReservationController {

    private ReservationService service;

    public ReservationController(ReservationService reservationService) {
        this.service = reservationService;
    }

    public String reserveBook(int studentId, int bookId) {
        if (service.reserveBookToStudent(studentId, bookId)) {
            return "Reserva feita com sucesso!";
        }

        return "Não foi possível reservar o livro!";
    }

    public String cancelReservation(int studentId, int bookId) {
        if (service.cancelStudentBookReservation(studentId, bookId)) {
            return "Devolução feita com sucesso!";
        }

        return "Não foi possível devolver o livro!";
    }

}
