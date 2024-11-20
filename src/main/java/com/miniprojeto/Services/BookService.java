package com.miniprojeto.Services;

import com.miniprojeto.Model.Book;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    private final String BOOK_API_URL = "https://qiiw8bgxka.execute-api.us-east-2.amazonaws.com/acervo/biblioteca";
    private final HttpClient client = HttpClient.newHttpClient();
    private final JsonParser<Book> parser = new BookJsonParser();
    private final List<Book> bookList = new ArrayList<>();

    public void loadAllBooks() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BOOK_API_URL))
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

}
