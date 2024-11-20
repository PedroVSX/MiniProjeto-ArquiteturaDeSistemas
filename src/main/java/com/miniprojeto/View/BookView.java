package com.miniprojeto.View;

import com.miniprojeto.Controller.BookController;
import com.miniprojeto.Model.Book;

import java.util.List;
import java.util.Scanner;

public class BookView {

    private BookViewMenu menu;
    private BookController controller;
    private Scanner input = new Scanner(System.in);

    public BookView(BookController controller) {
        this.controller = controller;
        this.menu = new BookViewMenu(this, controller);
    }

    public void manageStudentsBooks() {

    }

    public int getById() {
        String userInput = input.nextLine();
        int id;

        try {
            id = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            id = -1;
        }

        return id;
    }


    public void reservationSuccess() {
        System.out.println("Livro reservado com sucesso!");
    }

    public void reservationCancelSuccess() {
        System.out.println("Livro devolvido com sucesso!");
    }

    public void reservationError() {
        System.out.println("Não foi possível reservar o livro!");
    }

    public void reservationCancelError() {
        System.out.println("Não foi possível cancelar a reserva do livro!");
    }

    public void displayBooks(List<Book> books) {
        System.out.println("------------------------ Livros ------------------------");
        if (books.isEmpty()) {
            System.out.println("Não há livros disponíveis.");
        } else {
            for (Book book : books) {
                System.out.println(book + "\n");
            }
        }
    }

}
