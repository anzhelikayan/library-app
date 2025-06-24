package com.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class LibraryTest {

    @Test
    public void testBorrowAndReturnBook() {
        Book book = new Book("Test Book", "Author");
        Reader reader = new Reader("John");

        assertTrue(reader.borrowBook(book));
        assertFalse(book.isAvailable());

        assertTrue(reader.returnBook(book));
        assertTrue(book.isAvailable());
    }


    @Test
    public void testBorrowUnavailableBook() {
        Book book = new Book("Unavailable Book", "Author");
        Reader reader1 = new Reader("Reader1");
        Reader reader2 = new Reader("Reader2");

        assertTrue(reader1.borrowBook(book));
        assertFalse(reader2.borrowBook(book));
    }

    @Test
    public void testReturnBookNotOwned() {
        Book book = new Book("Another Book", "Author");
        Reader reader = new Reader("Reader");

        assertFalse(reader.returnBook(book));
    }
    
    @Test
    public void testAddBookToLibrary() {
        Library library = new Library();
        Book book = new Book("Java Basics", "Author A");
        library.addBook(book);
        assertTrue(library.getBooks().contains(book));
    }

    @Test
    public void testAddReaderToLibrary() {
        Library library = new Library();
        Reader reader = new Reader("Bob");
        library.addReader(reader);
        assertTrue(library.getReaders().contains(reader));
    }

    @Test
    public void testMultipleBorrowedBooks() {
        Reader reader = new Reader("John");
        Book book1 = new Book("Book1", "Author1");
        Book book2 = new Book("Book2", "Author2");

        assertTrue(reader.borrowBook(book1));
        assertTrue(reader.borrowBook(book2));
        assertEquals(2, reader.getBorrowedBooks().size());
    }

    @Test
    public void testDoubleReturnSameBook() {
        Book book = new Book("Book", "Author");
        Reader reader = new Reader("Reader");
        reader.borrowBook(book);
        assertTrue(reader.returnBook(book));
        assertFalse(reader.returnBook(book)); // книга вже повернена
    }

    @Test
    public void testBorrowSameBookBySameReaderTwice() {
        Book book = new Book("Repeated", "Author");
        Reader reader = new Reader("Reader");

        assertTrue(reader.borrowBook(book));
        assertFalse(reader.borrowBook(book)); // не може двічі позичити ту саму книгу
    }

    @Test
    public void testBookStatusChange() {
        Book book = new Book("Status Test", "Author");
        assertTrue(book.isAvailable());
        book.borrow();
        assertFalse(book.isAvailable());
        book.returnBook();
        assertTrue(book.isAvailable());
    }

=======
>>>>>>> dbeebb515d20458f97d526dc795a20493a05dc83
}