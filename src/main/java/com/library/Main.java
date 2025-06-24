package com.library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Book book1 = new Book("Clean Code", "Robert C. Martin");
        Book book2 = new Book("Effective Java", "Joshua Bloch");

        library.addBook(book1);
        library.addBook(book2);

        Reader reader = new Reader("Alice");
        library.addReader(reader);

        reader.borrowBook(book1);
        library.showBooks();
    }
}