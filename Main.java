package com.company;
import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    static User currentUser = new User();
    static boolean notFound = true;
    static boolean cont = true;
    static LoanController loan = new LoanController();
    static Vector<User> users = new Vector<User>();
    static Vector<Items> libraryItems = new Vector<Items>();

    public static void main(String[] args) {

        Books book1 = new Books("Harry Potter", 10, false, false, 50);
        book1.bestSeller = true;

        Books book2 = new Books("Hammock", 10, false, true, 1);
        Books book3 = new Books("Long John", 10, false, false, 7);

        Media media1 = new Media("The Avengers", 20, false, false, 100);

        Magazines mag1 = new Magazines("Vogue", 15, false, true, 200);
        Magazines mag2 = new Magazines("Life", 15, false, true, 20);

        User user1 = new User("Kevin", "1987 Marshall Rd", 123-456-7890,12345,18);
        User user2 = new User("Ted", "1987 Marshall Rd", 123-456-7890,12346,10);
        User user3 = new User("Stan", "134 san marcos Rd", 832-326-8313,12347,15);
        User user4 = new User("Kene", "227 Avalon ave Rd", 512-236-3123,12348,16);
        User user5 = new User("Scott", "313 John hopkins Rd", 512-765-6248,12349,22);

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        libraryItems.add(book1);
        libraryItems.add(book2);
        libraryItems.add(book3);
        libraryItems.add(media1);
        libraryItems.add(mag1);
        libraryItems.add(mag2);

        while(notFound){
            System.out.println("Please enter a valid library card number");
            int cardNumber = input.nextInt();
            for(int i = 0; i < users.size(); i++){
                if (cardNumber == users.get(i).cardNumber) {
                    notFound = false;
                    currentUser = users.get(i);

                    System.out.println("Welcome " + currentUser.name + "!");
                    String buffer  = input.nextLine();

                }
            }
        }

        menu();

        System.out.println("Goodbye!");

        /*loan.newLoan(user2, book1, "Book");
        loan.newLoan(user2, book1, "Book");
        loan.newLoan(user2, book1, "Book");
        loan.newLoan(user2, book1, "Book");
        loan.newLoan(user2, book1, "Book");
        loan.newLoan(user2, book1, "Book");
        System.out.println(user2.loans.get(0).itemTitle);
        System.out.println(user2.loans.get(0).dueDate);*/

    }
    static void menu(){
        System.out.println("What would you like to do?");
        System.out.println("1. Search for item");
        System.out.println("2. Show loan history");
        System.out.println("3. Request a book");
        System.out.println("4. Renew item");
        System.out.println("5. Exit");
        String option = input.nextLine();

        switch (option){
            case "1": itemSearch();
                break;
            case "2": loanHistory();
                break;
            case "3": itemRequest();
                break;
            case "4":
                if (Renew_Item() == 1)
                {
                    System.out.println("You have already renewed this item");
                    System.out.println("--------Now exiting program-------");
                    break;
                }
                else if (Renew_Item() != 1)
                {
                    break;
                }
                else
                    break;
            case "5":
                break;
        }
    }

    static void itemSearch(){
        while (cont) {
            notFound = true;
            System.out.println("What book, media, or magazine are you looking for? (Q to go back to menu)");
            String itemTitle = input.nextLine();


            if (itemTitle.equalsIgnoreCase("Q")){menu();}
            else {

                for (int i = 0; i < libraryItems.size(); i++) {
                    if (itemTitle.equalsIgnoreCase(libraryItems.get(i).title)) {
                        notFound = false;
                        Copies copy = new Copies();
                        if (copy.isAvailable(libraryItems.get(i).quantity)) {


                            if(libraryItems.get(i).reference) {
                                System.out.println("This is a reference copy that cannot be checked out.");
                                break;
                            }

                            System.out.println("This item is available, There are " + libraryItems.get(i).quantity + " copies available.");

                            System.out.println("Would you like to take this item on a loan?");
                            String onLoan = input.nextLine();
                            if (onLoan.equalsIgnoreCase("y") || onLoan.equalsIgnoreCase("yes")){
                                loan.newLoan(currentUser, libraryItems.get(i));
                                libraryItems.get(i).quantity = libraryItems.get(i).quantity-1;
                            }

                            //break;
                        } else {
                            System.out.println("Sorry, this item is not available at this time.");
                            //break;
                        }
                    }
                }
                if (notFound) {
                    System.out.println("There are no books, media, or magazines with that name. Please try again.");
                    System.out.println("Or enter + sign to request: ");

                }
            }
        }
    }

    static void loanHistory(){
        for (int i = 0; i < currentUser.loans.size(); i++){
            System.out.println("Title: " + currentUser.loans.get(i).itemTitle);
            System.out.println("Price: $" + currentUser.loans.get(i).value);
            System.out.println("Today's Date (Day of year): " + currentUser.loans.get(i).dayOfYear );
            System.out.println("Due Date (Day of year): " + currentUser.loans.get(i).dueDate());
            System.out.println("Fines incurred: $" + currentUser.loans.get(i).fine());
            System.out.println();
        }
    }
    static void itemRequest(){
        System.out.println("Please enter the name of the book");
        String Request = input.nextLine();
        System.out.println("Your request has been sent to the admin for confirmation. Going to Main page");
    }

    static int Renew_Item(){

        System.out.println("...You Selected renew item...");
        System.out.println("What item would you like to renew? ");
        String Renewed = input.nextLine();
        System.out.println("An extension for "+ Renewed +" is given!");
        System.out.println("Enter '1' to go to previous page or 2 to exit: ");

        int exit = input.nextInt();

        return exit;
    }
}
