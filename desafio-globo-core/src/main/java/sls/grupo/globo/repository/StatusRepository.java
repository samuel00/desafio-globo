package sls.grupo.globo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sls.grupo.globo.entity.Status;

@Repository
public interface StatusRepository extends CrudRepository<Status, Long> {

    Status findByName(String name);
}
