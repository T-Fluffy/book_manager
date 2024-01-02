package com.tarek.book_manager.Bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tarek.book_manager.Domain.Author;
import com.tarek.book_manager.Domain.Book;
import com.tarek.book_manager.Domain.Publisher;
import com.tarek.book_manager.Repositories.AuthorRepository;
import com.tarek.book_manager.Repositories.BookRepository;
import com.tarek.book_manager.Repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
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
        // adding the book to its author:
        eric_Saved.getBooks().add(DDD_Saved);
        // adding the author to his book:
        DDD_Saved.getAuthors().add(eric_Saved);

        //----------------------------------------------------------------------------------
        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB=new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("5463748");
        
        // rod Saved Data:
        Author rod_Saved=authorRepository.save(rod);
        Book noEJB_Saved=bookRepository.save(noEJB);
        // adding the book to its author:
        rod_Saved.getBooks().add(noEJB_Saved);
        // adding the author to his book:
        noEJB_Saved.getAuthors().add(rod_Saved);
        
        //Publisher Data:
        Publisher publisher=new Publisher();
        publisher.setPublisherName("My Publisher");
        publisher.setPublisherAddresse("123 Main");

        //Publisher saved Data:
        Publisher Publisher_Saved=publisherRepository.save(publisher);

        //Save book's publisher:
        DDD_Saved.setPublisher(Publisher_Saved);
        noEJB_Saved.setPublisher(Publisher_Saved);

        // Persist the Data:
        authorRepository.save(eric_Saved);
        authorRepository.save(rod_Saved);
        bookRepository.save(DDD_Saved);
        bookRepository.save(noEJB_Saved);
        //-----------------------------------------------------------------------------------
        System.out.println("In Bootstrap: ");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());

    }

   
    
}
