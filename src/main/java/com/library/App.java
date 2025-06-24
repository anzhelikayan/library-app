package com.library;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add book");
            System.out.println("2. Add reader");
            System.out.println("3. Borrow book");
            System.out.println("4. Return book");
            System.out.println("5. Show books");
            System.out.println("6. Show readers");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    library.addBook(new Book(title, author, isbn));
                }
                case 2 -> {
                    System.out.print("Enter reader name: ");
                    String name = scanner.nextLine();
                    library.addReader(new Reader(name));
                }
                case 3 -> {
                    System.out.print("Reader name: ");
                    String name = scanner.nextLine();
                    Reader reader = library.findReaderByName(name);
                    if (reader == null) {
                        System.out.println("Reader not found.");
                        break;
                    }
                    System.out.print("Enter ISBN of book to borrow: ");
                    String isbn = scanner.nextLine();
                    Book book = library.findBookByISBN(isbn);
                    if (book == null || !reader.borrowBook(book)) {
                        System.out.println("Book not available.");
                    } else {
                        System.out.println("Book borrowed.");
                    }
                }
                case 4 -> {
                    System.out.print("Reader name: ");
                    String name = scanner.nextLine();
                    Reader reader = library.findReaderByName(name);
                    if (reader == null) {
                        System.out.println("Reader not found.");
                        break;
                    }
                    System.out.print("Enter ISBN of book to return: ");
                    String isbn = scanner.nextLine();
                    Book book = library.findBookByISBN(isbn);
                    if (book == null || !reader.returnBook(book)) {
                        System.out.println("Book not returned.");
                    } else {
                        System.out.println("Book returned.");
                    }
                }
                case 5 -> library.getBooks().forEach(System.out::println);
                case 6 -> library.getReaders().forEach(System.out::println);
                case 0 -> {
                    System.out.println("Bye!");
                    return;
                }
            }
        }
    }
}
