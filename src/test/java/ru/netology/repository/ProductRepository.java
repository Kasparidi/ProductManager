package ru.netology.repository;

import java.awt.print.Book;

public class ProductRepository {
    private Book[] books = new Book[0];

    public void save(Book book) {
        int length = books.length + 1;
        Book[] tmp = new Book[length];
        System.arraycopy(books, 0, tmp, 0, books.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = book;
        books = tmp;
    }

    public Book[] findAll() {
        return books;
    }

    public void removeById (int id) {
        Book[] tmp = new Book[books.length - 1];
        int index = 0;
        for (Book book : books) {
            if (book.getId() != id) {
                tmp[index] = book;
                index++;
            }
        }
        books = tmp;
    }
}
