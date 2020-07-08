package sls.grupo.globo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sls.grupo.globo.entity.Subscription;

import java.util.Optional;

@Repository
public interface SignatureRepository extends CrudRepository<Subscription, Long> {

    Optional<Subscription> findBySubscription(String id);
}