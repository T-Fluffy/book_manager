package com.tarek.book_manager.Services;

import com.tarek.book_manager.Domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
