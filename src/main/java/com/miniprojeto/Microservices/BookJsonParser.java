package com.miniprojeto.Microservices;

import com.miniprojeto.Model.Book;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BookJsonParser implements JsonParser<Book> {

    @Override
    public List<Book> parse(String responseBody) {
        JSONArray booksJsonArray = new JSONArray(responseBody);
        List<Book> booksList = new ArrayList<>();

        for (int i = 0; i < booksJsonArray.length(); i++) {
            JSONObject bookObj = booksJsonArray.getJSONObject(i);
            Book book = new Book(
                    bookObj.getInt("id"),
                    bookObj.getString("titulo"),
                    bookObj.getString("autor"),
                    bookObj.getInt("ano"),
                    bookObj.getString("status").equalsIgnoreCase("Disponível")
            );

            booksList.add(book);
        }

        return booksList;
    }

}
