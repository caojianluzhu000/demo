package spring5.demo.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import spring5.demo.model.Author;
import spring5.demo.model.Book;
import spring5.demo.model.Publisher;
import spring5.demo.repositories.AuthorRepository;
import spring5.demo.repositories.BookRepository;
import spring5.demo.repositories.PublisherRepository;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }


    private void initData() {
        Publisher publisher1 = new Publisher("Harper Collins");
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Doman Driven Design", "1234", publisher1);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher1);


        Publisher publisher2 = new Publisher("Worx");
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE", "2344", publisher2);
        rod.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher2);

    }
}
