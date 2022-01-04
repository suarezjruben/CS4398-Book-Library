package com.company;

import java.util.Calendar;

public class Loan {
    public int checkoutDate;
    public int dueDate;
    public int cardNumber;
    public String itemTitle;
    public String type;
    Items item;
    Books book;
    double fine = 0;
    Calendar calendar = Calendar.getInstance();
    int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
    public int value;

    Loan(int checkoutDate,User user, Items item) {
        this.checkoutDate = checkoutDate;
        this.cardNumber = user.cardNumber;
        this.type = item.type;
        this.itemTitle = item.title;
        this.item = item;
        this.value = item.value;
    }

    public int dueDate() {
        if (type.equalsIgnoreCase("Media")) {
            this.dueDate = checkoutDate + 14;
        }
        else if (type.equalsIgnoreCase("Book")) {
            this.book = (Books) item;
            if(book.bestSeller){
                this.dueDate = checkoutDate + 14;
            }else {
                this.dueDate = checkoutDate + 21;
            }

        }
        return dueDate;
    }

    public double fine(){
        if (dayOfYear > dueDate){
            fine = dayOfYear-dueDate * .10;
        }
        return fine;
    }

}
