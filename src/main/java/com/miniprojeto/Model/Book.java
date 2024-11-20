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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
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
