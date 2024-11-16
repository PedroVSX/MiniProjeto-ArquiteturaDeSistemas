package com.miniprojeto.Model;

public class Book {

    private int id;
    private String title;
    private String author;
    private int year;
    private boolean status; // 0: Reservado | 1: Disponível

    public Book(int id, String title, String author, int year, boolean status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Id: " + id +
                "\nTítulo: " + title +
                "\nAutor: " + author +
                "\nAno: " + year +
                "\nStatus: " + (status ? "Disponível" : "Reservado");
    }

}
