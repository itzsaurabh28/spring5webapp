package kumar.saurabh.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import kumar.saurabh.spring5webapp.domain.Author;
import kumar.saurabh.spring5webapp.domain.Book;
import kumar.saurabh.spring5webapp.domain.Publisher;
import kumar.saurabh.spring5webapp.repositories.AuthorRepository;
import kumar.saurabh.spring5webapp.repositories.BookRepository;
import kumar.saurabh.spring5webapp.repositories.PublisherRepository;

@Component        
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {

		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain driven design", "123123");
		
		
		
		Publisher penguin = new Publisher();
		penguin.setName("Penguin");
		penguin.setAddressLine1("Upper East Side");
		penguin.setCity("New York");
		
		publisherRepository.save(penguin);      //for one to many relationship to work -- publisher needs to be saved first

		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		penguin.getBooks().add(ddd);
		ddd.setPublisher(penguin);
		

		authorRepository.save(eric);
		bookRepository.save(ddd);
		publisherRepository.save(penguin);

		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE development without EJB", "38383493");

		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		noEJB.setPublisher(penguin);
		penguin.getBooks().add(noEJB);
		
		

		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(penguin);
		

		System.out.println("Started in Bootstrap");
		System.out.println("no of book: " + bookRepository.count());

		System.out.println("added publisher");
		System.out.println("total no of publishers: " + publisherRepository.count());
		System.out.println("no of books publisher has: "+ penguin.getBooks().size());

	}

}
