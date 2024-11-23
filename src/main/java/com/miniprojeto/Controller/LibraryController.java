package com.miniprojeto.Controller;


import com.miniprojeto.Iterator.BookIterator;
import com.miniprojeto.Iterator.ModelIterator;
import com.miniprojeto.Model.Book;
import com.miniprojeto.Services.LibraryService;

import java.util.List;

public class LibraryController {

    private final LibraryService service;

    public LibraryController(LibraryService service) {
        this.service = service;
    }

    public String getAllBooks() {
        return bookIterator(service.getAllBooks());
    }

    public String getBookById(int id) {
        List<Book> books = service.getBooksById(id);

        if (!books.isEmpty()) {
            return bookIterator(books);
        }

        return "Nenhum livro foi encontrado!";
    }

    public String getBookByName(String name) {
        List<Book> books = service.getBooksByName(name);

        if (!books.isEmpty()) {
            return bookIterator(books);
        }

        return "Nenhum livro foi encontrado!";
    }

    public String bookIterator(List<Book> bookList) {
        ModelIterator<Book> iterator = new BookIterator(bookList);
        String s = "";

        s += iterator.getNext().toString() + "\n";

        return s;
    }

}
