package com.tarek.book_manager.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.tarek.book_manager.Domain.Author;

public interface AuthorRepository extends CrudRepository<Author,Long>{
    
}
