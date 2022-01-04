package com.company;

public class Copies {
    public int quantity;

    public boolean isAvailable(int quantity) {
        if(quantity <= 0) {
            return false;
        }
        else {
            return true;
        }
    }
}
