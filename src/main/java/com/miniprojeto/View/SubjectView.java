package com.miniprojeto.View;

import com.miniprojeto.Controller.SubjectController;
import com.miniprojeto.Model.Subject;

import java.util.List;
import java.util.Scanner;

public class SubjectView {

    private SubjectViewMenu menu;
    private SubjectController controller;
    private Scanner input = new Scanner(System.in);

    public SubjectView(SubjectController controller) {
        this.controller = controller;
        this.menu = new SubjectViewMenu(this, controller, controller.getStudentView());
    }

    public void enrollStudent() {
        menu.displaySubjectsToEnroll();
    }

    public void unenrollStudent() {
        menu.displaySubjectsToUnenroll();
    }

    public void enrollmentSuccess() {
        System.out.println("Estudante matriculado com sucesso!");
    }

    public void unenrollmentSuccess() {
        System.out.println("Estudante desmatriculado com sucesso!");
    }

    public void displayAllSubjects() {
        System.out.println("------------------------ Disciplinas ------------------------");
        controller.displayAllSubjects();
    }

    public void displaySubjects(List<Subject> subjects) {
        if (subjects.isEmpty()) {
            System.out.println("Não há disciplinas disponíveis.");
        } else {
            for (Subject subject : subjects) {
                System.out.println(subject + "\n");
            }
        }
    }
}
