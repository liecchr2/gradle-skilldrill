package edu.isu.cs.cs2263.gson;

import java.io.Serializable;
import java.util.Objects;

/*
Example of JSON data:
    {
        "firstName": "data",
        "lastName": "data",
        "number": {...},
        "email": "data",
        "officeLocation": "data",
    {

 */

public class Professor implements Serializable {

    String firstName;
    String lastName;
    PhoneNumber number;
    String email;
    String officeLocation;

    public Professor() {}

    public Professor(String firstName, String lastName, PhoneNumber number, String email, String officeLocation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.email = email;
        this.officeLocation = officeLocation;
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

    public PhoneNumber getNumber() {
        return number;
    }

    public void setNumber(PhoneNumber number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Professor)) return false;
        Professor professor = (Professor) o;
        return getFirstName().equals(professor.getFirstName()) &&
                getLastName().equals(professor.getLastName()) &&
                getNumber().equals(professor.getNumber()) &&
                getEmail().equals(professor.getEmail()) &&
                getOfficeLocation().equals(professor.getOfficeLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getNumber(), getEmail(), getOfficeLocation());
    }

    @Override
    public String toString() {
        return String.format("%s %s: %s", firstName, lastName, number.toString());
    }

}
