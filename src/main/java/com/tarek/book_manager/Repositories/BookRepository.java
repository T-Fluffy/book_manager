package com.tarek.book_manager.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.tarek.book_manager.Domain.Book;

public interface BookRepository extends CrudRepository<Book,Long> {
    
}
