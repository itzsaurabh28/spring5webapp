package guru.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring5webapp.domain.Author;

// needed as part of hibernate??

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
