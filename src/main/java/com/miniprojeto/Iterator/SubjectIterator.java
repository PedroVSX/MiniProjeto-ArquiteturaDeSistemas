package com.miniprojeto.Iterator;

import com.miniprojeto.Model.Subject;

import java.util.List;

public class SubjectIterator implements ModelIterator<Subject> {

    private int index;
    private final List<Subject> subjectList;

    public SubjectIterator(List<Subject> subjectList) {
        this.subjectList = subjectList;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < subjectList.size();
    }

    @Override
    public Subject getNext() {
        if (!hasNext()) {
            return null;
        }

        return subjectList.get(index++);
    }

    @Override
    public void reset() {
        index = 0;
    }

}
