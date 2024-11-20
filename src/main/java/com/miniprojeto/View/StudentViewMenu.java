package com.miniprojeto.View;

import com.miniprojeto.Controller.StudentController;

import java.util.Scanner;

public class StudentViewMenu {

    private StudentView view;
    private StudentController controller;
    private Scanner input = new Scanner(System.in);

    public StudentViewMenu(StudentView view, StudentController controller) {
        this.view = view;
        this.controller = controller;
    }

    private int showSearchOptions() {
        String s = ("""
                Escolha uma opção de busca:
                1 - Por curso
                2 - Por modalidade
                3 - Por curso e modalidade
                4 - Por ID
                5 - Por nome
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

        if (choice > 5 || choice < 0) {
            System.out.println("Escolha inválida!");
            return showSearchOptions();
        }

        return choice;
    }

    public void searchChoice() {
        int choice = showSearchOptions();

        switch (choice) {
            case 1 -> {
                controller.searchStudentsByCourse(
                        view.getByCourse()
                );
            }

            case 2 -> {
                controller.searchStudentsByModality(
                        view.getByModality().equals("EAD")
                );
            }

            case 3 -> {
                controller.searchStudentsByCourseAndModality(
                        view.getByCourse(), view.getByModality().equals("EAD")
                );
            }

            case 4 -> {
                controller.searchStudentsById(
                        view.getById()
                );
            }

            case 5 -> {
                controller.searchStudentsByName(
                        view.getByName()
                );
            }

            case 0 -> {
                return;
            }
        }

        view.searchStudent();
    }

}
