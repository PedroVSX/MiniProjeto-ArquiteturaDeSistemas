package com.miniprojeto.View;

import com.miniprojeto.Controller.StudentController;

public class StudentView {

    private StudentController controller;
    private InputHandler input = new InputHandler();

    public StudentView(StudentController studentController) {
        this.controller = studentController;
    }

    public void getAllStudents() {
        String response = controller.getAllStudents();
        System.out.println(response);
    }

    public void searchStudentById() {
        System.out.print("Digite o id do estudante: ");
        int id = input.getInt();

        String response = controller.searchById(id);

        System.out.println(response);
    }

    public void searchStudentByName() {
        System.out.println("Digite o nome do estudante: ");
        String name = input.getString();

        String response = controller.searchByName(name);

        System.out.println(response);
    }

    public void searchStudentByCourse() {
        System.out.println("Digite o curso do estudante: ");
        String course = input.getString();

        String response = controller.searchByCourse(course);

        System.out.println(response);
    }

    public void searchStudentByModality() {
        System.out.println("Digite a modalidade do estudante: ");
        String modality = input.getString();

        String response = controller.searchByModality(modality);

        System.out.println(response);
    }

    public void searchStudentByCourseAndModality() {
        System.out.println("Digite o curso do estudante: ");
        String course = input.getString();

        System.out.println("Digite a modalidade do estudante: ");
        String modality = input.getString();

        String response = controller.searchByCorseAndModality(course, modality);

        System.out.println(response);
    }

    public void getStudentEnrolledSubjects() {
        System.out.print("Digite o id do estudante: ");
        int id = input.getInt();

        String response = controller.getStudentSubjects(id);

        System.out.println(response);
    }

}
