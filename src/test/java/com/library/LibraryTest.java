package com.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
}