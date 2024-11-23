package com.miniprojeto.Iterator;

import com.miniprojeto.Model.Book;

import java.util.List;

public class BookIterator implements ModelIterator<Book> {

    private int index;
    private final List<Book> bookList;

    public BookIterator(List<Book> bookList) {
        this.bookList = bookList;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < bookList.size();
    }

    @Override
    public Book getNext() {
        if (!hasNext()) {
            return null;
        }

        return bookList.get(index++);
    }

    @Override
    public void reset() {
        index = 0;
    }

}
