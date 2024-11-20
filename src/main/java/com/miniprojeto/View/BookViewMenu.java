package com.miniprojeto.View;


import com.miniprojeto.Controller.BookController;

import java.util.Scanner;

public class BookViewMenu {

    private BookView view;
    private BookController controller;
    private Scanner input = new Scanner(System.in);

    public BookViewMenu(BookView view, BookController controller) {
        this.view = view;
        this.controller = controller;
    }

    public void showOptions() {
        String s = ("""
                Escolha a ação que deseja realizar:
                1 - Reservar um livro a um aluno
                2 - Cancelar a reserva de um livro de um aluno
                3 - Mostrar todos os livros
                0 - Sair
                
                """);

        System.out.print(s + "Sua escolha: ");

        int choice;
        try {
            String userInput = input.nextLine();
            choice = userInput.isEmpty() ? -1 : Integer.parseInt(userInput);

        } catch (NumberFormatException e) {
            choice = -1;
        }

        switch (choice) {
            case 0 -> {
                return;
            }
            case 1 -> displayBooksToReserve();

            case 2 -> displayBooksToCancelReservation();

            case 3 -> controller.displayAllBooks();

            default -> {
                System.out.println("Escolha inválida!");
                showOptions();
            }
        }

        view.manageStudentsBooks();
    }

    public void displayBooksToReserve() {
        controller.displayAllStudents();
        controller.displayAllBooks();

        System.out.print("Digite o ID do estudante que deseja fazer a reserva: ");
        int studentId = view.getById();

        System.out.print("Digite o ID do livro para a reserva: ");
        int bookId = view.getById();

        controller.reserveBookForStudent(studentId, bookId);
    }

    public void displayBooksToCancelReservation() {
        controller.displayAllStudents();
        controller.displayAllBooks();

        System.out.print("Digite o ID do estudante que deseja cancelar a reserva: ");
        int studentId = view.getById();

        System.out.print("Digite o ID do livro para a devolução: ");
        int bookId = view.getById();

        controller.cancelStudentBookReservation(studentId, bookId);
    }

}
