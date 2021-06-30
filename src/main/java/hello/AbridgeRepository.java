package hello;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AbridgeRepository extends CrudRepository<Abridge, Long> {
	Abridge findByHash(String hash);
}
