package com.miniprojeto.View;

import com.miniprojeto.Controller.SubjectController;
import com.miniprojeto.Model.Subject;

import java.util.List;
import java.util.Scanner;

public class SubjectView {

    private final SubjectViewMenu menu;
    private final SubjectController controller;
    private final Scanner input = new Scanner(System.in);

    public SubjectView(SubjectController controller) {
        this.controller = controller;
        this.menu = new SubjectViewMenu(this, controller);
    }

    public void manageStudentsSubjects() {
        menu.showOptions();
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

    public void enrollmentSuccess() {
        System.out.println("Estudante matriculado com sucesso!");
    }

    public void enrollmentError() {
        System.out.println("Não foi possível matricular o estudante!");
    }

    public void unenrollmentSuccess() {
        System.out.println("Estudante desmatriculado com sucesso!");
    }

    public void unenrollmentError() {
        System.out.println("Não foi possível desmatricular o estudante!");
    }

    public void displaySubjects(List<Subject> subjects) {
        System.out.println("------------------------ Disciplinas ------------------------");
        if (subjects.isEmpty()) {
            System.out.println("Não há disciplinas disponíveis.");
        } else {
            for (Subject subject : subjects) {
                System.out.println(subject + "\n");
            }
        }
    }
}
