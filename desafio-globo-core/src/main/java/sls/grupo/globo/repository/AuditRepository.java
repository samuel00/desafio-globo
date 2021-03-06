package sls.grupo.globo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sls.grupo.globo.entity.AuditSignature;

@Repository
public interface AuditRepository extends CrudRepository<AuditSignature, Long> {
}
