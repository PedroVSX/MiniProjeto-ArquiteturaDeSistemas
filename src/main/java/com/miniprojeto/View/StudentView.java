package com.miniprojeto.View;

import com.miniprojeto.Controller.StudentController;
import com.miniprojeto.Model.Student;

import java.util.List;
import java.util.Scanner;

public class StudentView {

    private StudentViewMenu menu;
    private StudentController controller;
    private Scanner input = new Scanner(System.in);

    public StudentView(StudentController controller) {
        this.controller = controller;
        this.menu = new StudentViewMenu(this, controller);
    }

    public void searchStudent() {
        menu.searchChoice();
    }

    protected String getByCourse() {
        System.out.print("Digite o curso: ");
        return input.nextLine().toUpperCase();
    }

    protected String getByModality() {
        System.out.print("Digite a modalidade: ");
        String modality = input.nextLine().toUpperCase();

        switch (modality) {
            case "EAD", "PRESENCIAL" -> {
                return modality;
            }

            default -> {
                System.out.println("Digite uma modalidade válida!");
                return getByModality();
            }
        }
    }

    protected int getById() {
        System.out.print("Digite o id: ");
        int id;
        try {
            id = Integer.parseInt(input.nextLine());

        } catch (Exception e) {
            System.out.println("Insira um número!");
            id = getById();
        }

        return id;
    }

    protected String getByName() {
        System.out.print("Digite o nome: ");
        return input.nextLine();
    }

    public void displayAllStudents() {
        System.out.println("------------------------ Estudantes ------------------------");
        controller.displayAllStudents();
    }

    public void displayStudents(List<Student> list) {
        for (Student student : list) {
            System.out.println(student + "\n");
        }
    }
}
