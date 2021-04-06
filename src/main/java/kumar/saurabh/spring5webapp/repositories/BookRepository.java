package kumar.saurabh.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import kumar.saurabh.spring5webapp.domain.Book;



public interface BookRepository extends CrudRepository<Book, Long>{

}
