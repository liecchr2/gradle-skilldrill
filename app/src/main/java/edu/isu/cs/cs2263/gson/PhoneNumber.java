package edu.isu.cs.cs2263.gson;

import java.io.Serializable;
import java.util.Objects;

/*
Example of JSON data:
    {
        "areaCode": "data",
        "number": "data",
    {

 */

public class PhoneNumber implements Serializable {

    String areaCode;
    String number;

    public PhoneNumber() {}

    public PhoneNumber(String areaCode, String number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber)) return false;
        PhoneNumber that = (PhoneNumber) o;
        return getAreaCode().equals(that.getAreaCode()) &&
                getNumber().equals(that.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAreaCode(), getNumber());
    }

    @Override
    public String toString(){
        return String.format("(%s) %s", areaCode, number);
    }
}
