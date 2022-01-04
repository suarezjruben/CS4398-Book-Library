package com.company;
import java.util.*;

public class LoanController {
    User user;
    Items item;
    Loan loan;
    Calendar calendar = Calendar.getInstance();
    int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);

    public void newLoan(User user, Items item){
        if (user.age <=12 && user.numItems() >=5){
            System.out.println("Sorry, children 12 and under are only allowed 5 loans!");
        }
        else{
            loan = new Loan(dayOfYear,user,item);
            user.loans.add(loan);
            user.incrementCounter();
        }
    }

}
