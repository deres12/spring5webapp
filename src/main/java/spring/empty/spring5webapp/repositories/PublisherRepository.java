package spring.empty.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.empty.spring5webapp.model.Publisher;


public interface PublisherRepository  extends CrudRepository<Publisher, Long> {
}
