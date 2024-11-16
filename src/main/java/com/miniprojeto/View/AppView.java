package com.miniprojeto.View;

import com.miniprojeto.Controller.AppController;

import java.util.Scanner;

public class AppView {

    private AppController controller;
    Scanner input = new Scanner(System.in);

    public AppView(AppController controller) {
        this.controller = controller;
    }

}
