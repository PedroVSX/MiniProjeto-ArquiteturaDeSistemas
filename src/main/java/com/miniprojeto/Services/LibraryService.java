package com.miniprojeto.Services;

import com.miniprojeto.Model.Book;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class LibraryService {

    private final String LIBRARY_API_URL = "https://qiiw8bgxka.execute-api.us-east-2.amazonaws.com/acervo/biblioteca";
    private final HttpClient client = HttpClient.newHttpClient();
    private final JsonParser<Book> parser = new LibraryJsonParser();
    private final List<Book> bookList = new ArrayList<>();

    public LibraryService() {
        loadAllBooks();
    }

    public void loadAllBooks() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(LIBRARY_API_URL))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            List<Book> books = parser.parse(response.body());

            bookList.clear();
            bookList.addAll(books);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        return bookList;
    }

    public List<Book> getBooksById(int id) {
        return bookList.stream()
                .filter(book -> book.getId() == id)
                .toList();
    }

    public List<Book> getBooksByName(String name) {
        return bookList.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(name))
                .toList();
    }
}
