package com.miniprojeto.View;

import com.miniprojeto.Controller.LibraryController;
import com.miniprojeto.Controller.ReservationController;

public class LibraryView {

    private LibraryController libraryController;
    private ReservationController reservationController;
    private InputHandler input = new InputHandler();

    public LibraryView(LibraryController libraryController, ReservationController reservationController) {
        this.libraryController = libraryController;
        this.reservationController = reservationController;
    }

    public void getAllBooks() {
        String response = libraryController.getAllBooks();
        System.out.println(response);
    }

    public void searchBookById() {
        System.out.print("Digite o id do livro: ");
        int id = input.getInt();

        String response = libraryController.getBookById(id);

        System.out.println(response);
    }

    public void searchBookByName() {
        System.out.print("Digite o nome do livro: ");
        String name = input.getString();

        String response = libraryController.getBookByName(name);

        System.out.println(response);
    }

    public void reserveBookToStudent() {
        System.out.print("Digite o id do estudante para reserva: ");
        int studentId = input.getInt();

        System.out.print("Digite o id do livro a ser reservado: ");
        int bookId = input.getInt();

        String response = reservationController.reserveBook(studentId, bookId);

        System.out.println(response);
    }

    public void cancelStudentBookReservation() {
        System.out.print("Digite o id do estudante para devolução: ");
        int studentId = input.getInt();

        System.out.print("Digite o id do livro a ser devolvido: ");
        int bookId = input.getInt();

        String response = reservationController.cancelReservation(studentId, bookId);

        System.out.println(response);
    }

}
