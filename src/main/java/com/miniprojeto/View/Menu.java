package com.miniprojeto.View;

import com.miniprojeto.Controller.*;

public class Menu {

    private StudentView studentView;
    private SubjectView subjectView;
    private LibraryView libraryView;
    private InputHandler input = new InputHandler();

    public Menu(StudentView studentView, SubjectView subjectView, LibraryView libraryView) {
        this.studentView = studentView;
        this.subjectView = subjectView;
        this.libraryView = libraryView;
    }

    public void start() {
        String title = ("""
                ----------------------------------------
                                  MENU                 \s
                ----------------------------------------
                """);

        String options = ("""
                1 - Mostrar todos os estudantes
                2 - Mostrar todas as disciplinas
                3 - Mostrar todos os livros
                4 - Procurar estudantes por ID
                5 - Procurar estudantes por nome
                6 - Procurar estudantes por curso
                7 - Procurar estudantes por modalidade
                8 - Procurar estudantes por curso e modalidade
                9 - Mostrar disciplinas de um estudante
                10 - Mostrar livros reservados de um estudante
                11 - Procurar disciplina por ID
                12 - Procurar disciplina por nome
                13 - Matricular estudante em disciplina
                14 - Desmatricular estudante de disciplina
                15 - Procurar livro por ID
                16 - Procurar livro por nome
                17 - Reservar livro a um estudante
                18 - Devolver livro de um estudante
                0 - Sair da aplicação
                
                """);

        System.out.print(title + options + "Sua escolha: ");
        selection(input.getInt());
    }

    private void selection(int choice) {
        switch (choice) {
            case 0 -> {
                return;
            }
            case 1 -> studentView.getAllStudents();
            case 2 -> subjectView.getAllSubjects();
            case 3 -> libraryView.getAllBooks();
            case 4 -> studentView.searchStudentById();
            case 5 -> studentView.searchStudentByName();
            case 6 -> studentView.searchStudentByCourse();
            case 7 -> studentView.searchStudentByModality();
            case 8 -> studentView.searchStudentByCourseAndModality();
            case 9 -> studentView.getStudentEnrolledSubjects();
            case 10 -> studentView.getStudentReservedBooks();
            case 11 -> subjectView.searchSubjectById();
            case 12 -> subjectView.searchSubjectByName();
            case 13 -> subjectView.enrollStudentInSubject();
            case 14 -> subjectView.unenrollStudentInSubject();
            case 15 -> libraryView.searchBookById();
            case 16 -> libraryView.searchBookByName();
            case 17 -> libraryView.reserveBookToStudent();
            case 18 -> libraryView.cancelStudentBookReservation();
            default -> System.out.println("Opção inválida!");
        }

        start();
    }

}
