package spring5.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import spring5.demo.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
