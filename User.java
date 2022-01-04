package com.company;
import java.util.*;


public class User {
    public String name;
    public String address;
    public int phoneNumber;
    public int cardNumber;
    public int age;
    public Vector<Loan> loans = new Vector<Loan>();
    public int counter;

    User() {

    }

    User(String name, String address, int phoneNumber, int cardNumber, int age) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.cardNumber = cardNumber;
        this.age = age;
    }

    public void incrementCounter() {
        counter++;
    }

    public int numItems() {
        return counter;
    }
}

