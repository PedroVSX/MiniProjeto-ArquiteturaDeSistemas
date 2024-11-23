package com.miniprojeto.Iterator;

import com.miniprojeto.Model.Student;

import java.util.List;

public class StudentIterator implements ModelIterator<Student> {

    private int index;
    private final List<Student> studentList;

    public StudentIterator(List<Student> studentList) {
        this.studentList = studentList;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < studentList.size();
    }

    @Override
    public Student getNext() {
        if (!hasNext()) {
            return null;
        }

        return studentList.get(index++);
    }

    @Override
    public void reset() {
        index = 0;
    }

}
