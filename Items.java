package com.company;

public class Items {

    public String title;
    public int value;
    public boolean requests;
    public boolean reference;
    public int quantity;
    public String type;

    Items(String title, int value, boolean requests, boolean reference, int quantity, String type) {
        this.title = title;
        this.value = value;
        this.requests = requests;
        this.reference = reference;
        this.quantity = quantity;
        this.type = type;
    }
}
