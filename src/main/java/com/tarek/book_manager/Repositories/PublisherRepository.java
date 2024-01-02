package com.tarek.book_manager.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.tarek.book_manager.Domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher,Long>{
    
}
