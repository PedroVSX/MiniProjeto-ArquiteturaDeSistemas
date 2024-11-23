package com.miniprojeto.View;


import com.miniprojeto.Controller.EnrollmentController;
import com.miniprojeto.Controller.SubjectController;

public class SubjectView {

    private SubjectController subjectController;
    private EnrollmentController enrollmentController;
    private InputHandler input = new InputHandler();

    public SubjectView(SubjectController subjectController, EnrollmentController enrollmentController) {
        this.subjectController = subjectController;
        this.enrollmentController = enrollmentController;
    }

    public void getAllSubjects() {
        String response = subjectController.getAllSubjects();
        System.out.println(response);
    }

    public void searchSubjectById() {
        System.out.print("Digite o id da disciplina: ");
        int id = input.getInt();

        String response = subjectController.getSubjectById(id);

        System.out.println(response);
    }

    public void searchSubjectByName() {
        System.out.print("Digite o nome da disciplina: ");
        String name = input.getString();

        String response = subjectController.getSubjectByName(name);

        System.out.println(response);
    }

    public void enrollStudentInSubject() {
        System.out.print("Digite o id do estudante a ser matriculado: ");
        int studentId = input.getInt();

        System.out.println("Digite o id da disciplina a matricular: ");
        int subjectId = input.getInt();

        String response = enrollmentController.enrollStudent(studentId, subjectId);

        System.out.println(response);
    }

    public void unenrollStudentInSubject() {
        System.out.print("Digite o id do estudante a ser desmatriculado: ");
        int studentId = input.getInt();

        System.out.println("Digite o id da disciplina a desmatricular: ");
        int subjectId = input.getInt();

        String response = enrollmentController.unenrollStudent(studentId, subjectId);

        System.out.println(response);
    }

}
