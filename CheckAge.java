package com.company;

public class CheckAge {
    public int age;

    public boolean checkAge(int age) {
        if(age <= 12) {
            return false;
        }
        else  {
            return true;
        }
    }
}
