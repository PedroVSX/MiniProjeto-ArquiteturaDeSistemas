package com.miniprojeto.View;

import java.util.Scanner;

public class InputHandler {

    private Scanner input = new Scanner(System.in);

    public String getString() {
        String s = input.nextLine();

        while (s.isEmpty()) {
            System.out.print("Digite algo que não é vazio!\nSeu input: ");
            s = input.nextLine();
        }

        return s;
    }

    public int getInt() {
        String s = input.nextLine();

        while (!s.matches("\\d+")) {
            System.out.print("Digite apenas números!\nSeu input: ");
            s = input.nextLine();
        }

        return Integer.parseInt(s);
    }

}
