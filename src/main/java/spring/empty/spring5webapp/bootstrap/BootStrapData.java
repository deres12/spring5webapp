package spring.empty.spring5webapp.bootstrap;

import jdk.management.cmm.SystemResourcePressureMXBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.empty.spring5webapp.model.Author;
import spring.empty.spring5webapp.model.Book;
import spring.empty.spring5webapp.model.Publisher;
import spring.empty.spring5webapp.repositories.AuthorRepository;
import spring.empty.spring5webapp.repositories.BookRepository;
import spring.empty.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Boostrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");
        publisherRepository.save(publisher);

        System.out.println("Number of Publisher: "+ publisherRepository.count());

        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod","Jonson");
        Book noEjb = new Book("J2EE Development without EJB","3939459459");
        rod.getBooks().add(noEjb);
        noEjb.getAuthors().add(rod);

        noEjb.setPublisher(publisher);
        publisher.getBooks().add(noEjb);

        authorRepository.save(rod);
        bookRepository.save(noEjb);
        publisherRepository.save(publisher);


        System.out.println("Number of Books: "+ bookRepository.count());
        System.out.println("Publisher Number of Books: "+ publisher.getBooks().size());
    }
}
