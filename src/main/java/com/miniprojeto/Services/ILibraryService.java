package com.miniprojeto.Services;

import com.miniprojeto.Model.Book;

import java.util.List;

public interface ILibraryService {

    void loadAllBooks();
    List<Book> getAllBooks();
    List<Book> getBooksById(int id);
    List<Book> getBooksByName(String name);

}
