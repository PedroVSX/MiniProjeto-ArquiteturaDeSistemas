package com.miniprojeto.View;

import com.miniprojeto.Controller.*;

public class Menu {

    private final MenuController controller;
    private final InputHandler input = new InputHandler();

    public Menu(MenuController controller) {
        this.controller = controller;
    }

    public void start() {
        int choice;

        do {
            displayMenu();
            choice = input.getInt();
            controller.selection(choice);
        } while (choice != 0);
    }

    private void displayMenu() {
        String title = """
                ----------------------------------------
                                  MENU                \s
                ----------------------------------------
               """;

        String options = """
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
                
                """;

        System.out.print(title + options + "Sua escolha: ");
    }
}
