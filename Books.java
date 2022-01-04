package com.company;

public class Books extends Items {
    public boolean bestSeller;

    Books(String title, int value, boolean requests, boolean reference, int quantity) {
        super(title, value, requests, reference, quantity, "Book");
    }

}
