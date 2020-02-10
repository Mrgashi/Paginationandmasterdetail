package com.example.BookStore;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookRepository {
    private List<Book> books;
    Faker faker = new Faker();

    public BookRepository() {
        books = new ArrayList<>();

        for (int i = 1; i <= 95; i++) {
            books.add(new Book(i, faker.book().title(), faker.book().author(), 40 + i + 1.99, "Dec 31, " + (1910 + i)));
        }
    }

    public List<Book> getPage(int page, int pageSize) {
        int from = Math.max(0, page * pageSize);
        int to = Math.min(books.size(), (page + 1) * pageSize);

        return books.subList(from, to);
    }

    public int numberOfPages(int pageSize) {
        return (int) Math.ceil((double) books.size() / pageSize);
    }

    public Book getBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

}
