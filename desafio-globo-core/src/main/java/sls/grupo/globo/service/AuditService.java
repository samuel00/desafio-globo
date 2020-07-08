package sls.grupo.globo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sls.grupo.globo.entity.AuditSignature;
import sls.grupo.globo.entity.AuditSignatureDTO;
import sls.grupo.globo.repository.AuditRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AuditService {

    AuditRepository auditRepository;

    @Autowired
    public AuditService(AuditRepository auditRepository){
        this.auditRepository = auditRepository;
    }

    public List<AuditSignatureDTO> findAll(){
        List<AuditSignatureDTO> list = new ArrayList();
        Iterable<AuditSignature> iterable = this.auditRepository.findAll();
        for (AuditSignatureDTO auditSignatureDTO : iterable){
            list.add(auditSignatureDTO);
        }
        log.info("List Find All {}", list);
        return list;
    }
}
