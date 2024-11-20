package com.miniprojeto.View;

import com.miniprojeto.Controller.SubjectController;

import java.util.Scanner;

public class SubjectViewMenu {

    private SubjectView view;
    private SubjectController controller;
    private Scanner input = new Scanner(System.in);

    public SubjectViewMenu(SubjectView view, SubjectController controller) {
        this.controller = controller;
    }

    public void showOptions() {
        String s = ("""
                Escolha a ação que deseja realizar:
                1 - Matricular aluno em uma disciplina
                2 - Desmatricular aluno de uma disciplina
                3 - Mostrar todas as disciplinas
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
            case 1 -> displaySubjectsToEnroll();

            case 2 -> displaySubjectsToUnenroll();

            case 3 -> controller.displayAllSubjects();

            default -> {
                System.out.println("Escolha inválida!");
                showOptions();
            }
        }

        view.manageStudentsSubjects();
    }

    public void displaySubjectsToEnroll() {
        controller.displayAllStudents(); // Agora o controlador exibe os estudantes
        controller.displayAllSubjects(); // Exibe as disciplinas

        System.out.print("Digite o ID do estudante que você deseja matricular: ");
        int studentId = view.getById();

        System.out.print("Digite o ID da disciplina para matricular: ");
        int subjectId = view.getById();

        controller.enrollStudentInSubject(studentId, subjectId);
    }

    public void displaySubjectsToUnenroll() {
        controller.displayAllStudents(); // Agora o controlador exibe os estudantes
        controller.displayAllSubjects(); // Exibe as disciplinas

        System.out.print("Digite o ID do estudante que você deseja desmatricular: ");
        int studentId = view.getById();

        System.out.print("Digite o ID da disciplina para desmatricular: ");
        int subjectId = view.getById();

        controller.unenrollStudentFromSubject(studentId, subjectId);
    }
}
