package edu.isu.cs.cs2263;

import java.util.ArrayList;

public class Student {
    //Instance Variables
    String firstName;
    String lastName;
    ArrayList<Course> courseList = new ArrayList<>();

    public Student() {}

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Method to get the course list
    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Course> courses){
        courseList = courses;
    }

    //Method to add the course list
    public boolean add(Course c){
        return courseList.add(c);
    }

    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }
}
