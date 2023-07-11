package com;
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private int isbnNo;
    private String bookName;
    private String author;

    public int getIsbnNo() {
        return isbnNo;
    }

    public void setIsbnNo(int isbnNo) {
        this.isbnNo = isbnNo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class Library {
    private ArrayList<Book> bookList = new ArrayList<Book>();

    public void addBook(Book bobj) {
        bookList.add(bobj);
    }

    public boolean isEmpty() {
        return bookList.isEmpty();
    }

    public ArrayList<Book> viewAllBooks() {
        return bookList;
    }

    public ArrayList<Book> viewBooksByAuthor(String author) {
        ArrayList<Book> booksByAuthor = new ArrayList<Book>();
        for (Book book : bookList) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("1. Add a Book");
            System.out.println("2. Display all book details");
            System.out.println("3. Search Book by Name of author");
            System.out.println("4. Count number of books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    Book book = new Book();
                    System.out.print("Enter the book no: ");
                    book.setIsbnNo(scanner.nextInt());
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter the book name: ");
                    book.setBookName(scanner.nextLine());
                    System.out.print("Enter the author name: ");
                    book.setAuthor(scanner.nextLine());
                    library.addBook(book);
                    break;
                case 2:
                    ArrayList<Book> allBooks = library.viewAllBooks();
                    if (allBooks.isEmpty()) {
                        System.out.println("The list is empty");
                    } else {
                        for (Book b : allBooks) {
                            System.out.println("book no: " + b.getIsbnNo());
                            System.out.println("Book name: " + b.getBookName());
                            System.out.println("Author name: " + b.getAuthor());
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter the author name: ");
                    String author = scanner.nextLine();
                    ArrayList<Book> booksByAuthor = library.viewBooksByAuthor(author);
                    if (booksByAuthor.isEmpty()) {
                        System.out.println("No books available of this author " + author);
                    } else {
                        for (Book b : booksByAuthor) {
                            System.out.println("book no: " + b.getIsbnNo());
                            System.out.println("Book name: " + b.getBookName());
                            System.out.println("Author name: " + b.getAuthor());
                        }
                    }
                    break;
               
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
