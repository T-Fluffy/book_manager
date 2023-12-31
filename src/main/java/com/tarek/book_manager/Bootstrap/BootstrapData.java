package com.tarek.book_manager.Bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tarek.book_manager.Domain.Author;
import com.tarek.book_manager.Domain.Book;
import com.tarek.book_manager.Repositories.AuthorRepository;
import com.tarek.book_manager.Repositories.BookRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book DDD=new Book();
        DDD.setTitle("Domain Driven Design");
        DDD.setIsbn("123456");
        
        // eric Saved Data:
        Author eric_Saved=authorRepository.save(eric);
        Book DDD_Saved=bookRepository.save(DDD);
        eric_Saved.getBooks().add(DDD_Saved);
        //------------------------------------------------------
        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB=new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("5463748");
        
        // rod Saved Data:
        Author rod_Saved=authorRepository.save(rod);
        Book noEJB_Saved=bookRepository.save(noEJB);
        rod_Saved.getBooks().add(noEJB_Saved);
        // Persist the data:
        authorRepository.save(eric_Saved);
        authorRepository.save(rod_Saved);

        //------------------------------------------------------
        System.out.println("In Bootstrap :");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());


    }

   
    
}
