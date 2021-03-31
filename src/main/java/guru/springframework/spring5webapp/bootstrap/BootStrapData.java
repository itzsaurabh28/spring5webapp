package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;


@Component
public class BootStrapData implements CommandLineRunner{
	
	
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
		
		Author eric= new Author("Eric","Evans");
		Book ddd=new Book("Domain driven design","123123");
		
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		
		Author rod=new Author("Rod","Johnson");
		Book noEJB=new Book("J2EE development without EJB","38383493");
		
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		
		System.out.println("Started in Bootstrap");
		System.out.println("no of book: " + bookRepository.count());
		
		
		Publisher penguin=new Publisher("Penguin","Upper East Side","New York","New york", "12536");
		
		publisherRepository.save(penguin);
		System.out.println("added publisher");
		System.out.println("total no of publishers: "+ publisherRepository.count());
		
		
		
	}
	
	
	
	
	
	
	

}
