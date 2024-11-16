package com.miniprojeto.View;

import com.miniprojeto.Controller.SubjectController;

import java.util.Scanner;

public class SubjectViewMenu {

    private SubjectView view;
    private SubjectController controller;
    private StudentView studentView;
    private Scanner input = new Scanner(System.in);

    public SubjectViewMenu(SubjectView view, SubjectController controller, StudentView studentView) {
        this.view = view;
        this.controller = controller;
        this.studentView = studentView;
    }

    public void displaySubjectsToEnroll() {
        studentView.displayAllStudents();
        view.displayAllSubjects();

        System.out.print("Digite o ID do estudante que você deseja matricular: ");

        int studentId;
        int subjectId;
        try {
            String userInput = input.nextLine();
            studentId = userInput.isEmpty() ? -1 : Integer.parseInt(userInput);

            System.out.print("Digite o ID da disciplina para matricular: ");
            userInput = input.nextLine();
            subjectId = userInput.isEmpty() ? -1 : Integer.parseInt(userInput);

        } catch (NumberFormatException e) {
            studentId = -1;
            subjectId = -1;
        }

        if (studentId < 0 || subjectId < 0) {
            System.out.println("Escolha inválida!");
            displaySubjectsToEnroll();
        }

        try {
            controller.enrollStudentInSubject(studentId, subjectId);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Escolha inválida!");
            displaySubjectsToEnroll();
        }
    }

    public void displaySubjectsToUnenroll() {
        studentView.displayAllStudents();
        view.displayAllSubjects();

        System.out.print("Digite o ID do estudante que você deseja desmatricular: ");

        int studentId;
        int subjectId;
        try {
            String userInput = input.nextLine();
            studentId = userInput.isEmpty() ? -1 : Integer.parseInt(userInput);

            System.out.print("Digite o ID da disciplina para desmatricular: ");
            userInput = input.nextLine();
            subjectId = userInput.isEmpty() ? -1 : Integer.parseInt(userInput);

        } catch (NumberFormatException e) {
            studentId = -1;
            subjectId = -1;
        }

        if (studentId < 0 || subjectId < 0) {
            System.out.println("Escolha inválida!");
            displaySubjectsToUnenroll();
        }

        try {
            controller.unenrollStudentFromSubject(studentId, subjectId);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Escolha inválida!");
            displaySubjectsToUnenroll();
        }
    }
}
