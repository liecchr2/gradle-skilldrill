package edu.isu.cs.cs2263;

public class Course {
    //Instance Variables
    int number;
    String subject;
    String title;

    public Course() {}

    public Course(int number, String subject, String title) {
        this.number = number;
        this.subject = subject;
        this.title = title;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", subject, number, title);
    }
}
