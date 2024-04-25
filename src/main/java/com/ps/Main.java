package com.ps;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int command;
        int availableCommand;
        int checkedOutCommand;
        //new instances of book
        Book book1 = new Book(1, "0385721676", "Oryx & Crake", false, null);
        Book book2 = new Book(2, "9798703802830", "The Communist Manifesto", false, null);
        Book book3 = new Book(3, "0441013597", "Dune", false, null);
        Book book4 = new Book(4, "0786838655", "The Lightning Thief", false, null);
        Book book5 = new Book(5, "0316421979", "The Ten Thousand Doors of January", false, null);
        Book book6 = new Book(6, "0306824205", "Friday Night Lights", false, null);
        Book book7 = new Book(7, "0007525540", "Lord of the Rings", false, null);
        Book book8 = new Book(8, "0553808044", "A Game of Thrones", false, null);
        Book book9 = new Book(9, "9798864630365", "The Will to Change", false, null);
        Book book10 = new Book(10, "0307700461", "The Buddha in the Attic", false, null);
        Book book11 = new Book(11, "0062464345", "Homo Deus", false, null);
        Book book12 = new Book(12, "0565095021", "On the Origin of Species", false, null);
        Book book13 = new Book(13, "0670881465", "The 48 Laws of Power", false, null);
        Book book14 = new Book(14, "1612681123", "Rich Dad Poor Dad", false, null);
        Book book15 = new Book(15, "0374158274", "Give Us the Ballot", false, null);
        Book book16 = new Book(16, "0241408407", "Women, Race, and Class", false, null);
        Book book17 = new Book(17, "006306488X", "System Error", false, null);
        Book book18 = new Book(18, "1600785263", "Rockin' Steady", false, null);
        Book book19 = new Book(19, "1795754613", "State and Revolution", false, null);
        Book book20 = new Book(20, "1644210681", "The Motorcycle Diaries", false, null);


// arrays of books
        Book[] bookInventory = {book1, book2, book3, book4, book5, book6, book7, book8, book9, book10, book11, book12, book13, book14, book15, book16, book17, book18, book19, book20};
        String[] checkedOutBooks = new String[0];

        Scanner scanner = new Scanner(System.in);
        do {
            //home screen
            System.out.println("Welcome to the Neighborhood Library!");
            System.out.println("Please choose an option: ");
            System.out.println("\t1) Show available books");
            System.out.println("\t2) Show checked out books");
            System.out.println("\t3) Check in a book");
            System.out.println("\t4) Exit menu");


            command = scanner.nextInt();

            switch (command) {
                case 1:
                    System.out.println("Show available books");
                    //Display array of available book
                    for (int i = 0; i < bookInventory.length; i++) {
                        System.out.println("\t" + bookInventory[i].getTitle());
                    }
                    int subCommand;
                    do {
                        System.out.println("Enter the id of the book to check out or 0 to return to the main menu.");
                        subCommand = scanner.nextInt();
                        if (subCommand >= 1 && subCommand <= bookInventory.length) {
                            Book selectedBook = bookInventory[subCommand - 1];
                            if (!selectedBook.isCheckedOut()) {
                                System.out.println("Please enter your name");
                                scanner.nextLine();
                                selectedBook.checkOut(scanner.nextLine());
                                System.out.println(selectedBook.getTitle() + " checked out successfully.");
                            } else {
                                System.out.println("Sorry, the book is already checked out.");
                            }
                        } else if (subCommand != 0) {
                            System.out.println("Invalid input. Please enter a valid book number.");
                        }
                    } while (subCommand != 0);
                    break;

                case 2:
                    System.out.println("Show checked out books");
                    boolean noCheckedOutBooks = true;
                    for (Book book : bookInventory) {
                        if (book.isCheckedOut()) {
                            System.out.println("\t- " + book.getTitle() + " " + "Checked out to: " + book.getCheckedOutTo());
                            noCheckedOutBooks = false;
                        }
                    }
                    if (noCheckedOutBooks) {
                        System.out.println("No books are currently checked out.");
                    }
                    break;
                case 3:
                    System.out.println("Check in a book");
                    System.out.println("Enter the the title of the book to check in: ");
                    scanner.nextLine();
                    String bookToCheckIn = scanner.nextLine();
                    for (Book book : bookInventory) {
                        if (book.getTitle().equalsIgnoreCase(bookToCheckIn) && book.isCheckedOut()) {
                            Book.checkIn(book);
                            System.out.println("Book checked in successfully.");
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exit menu");
                    break;
                default:
                    System.out.println("Command not found");

            }


        } while (command != 4);


    }
}