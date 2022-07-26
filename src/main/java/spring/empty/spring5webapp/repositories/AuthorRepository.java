package spring.empty.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.empty.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
