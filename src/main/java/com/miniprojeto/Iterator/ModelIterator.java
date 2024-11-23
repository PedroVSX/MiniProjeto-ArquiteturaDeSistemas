package com.miniprojeto.Iterator;

public interface ModelIterator<T> {

    boolean hasNext();

    T getNext();

    void reset();

}
