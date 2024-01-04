package com.tarek.book_manager.Services;

import org.springframework.stereotype.Service;

import com.tarek.book_manager.Domain.Book;
import com.tarek.book_manager.Repositories.BookRepository;

@Service    
public class BookServiceImplmentation implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImplmentation(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
    
}
