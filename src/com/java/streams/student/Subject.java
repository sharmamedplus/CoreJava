package com.java.streams.student;

import java.util.List;

public class Subject {
    String subjectName;
    int mark;

    public Subject(String subjectName, int mark) {
        this.mark = mark;
        this.subjectName = subjectName;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectName='" + subjectName + '\'' +
                ", mark=" + mark +
                '}';
    }
}
