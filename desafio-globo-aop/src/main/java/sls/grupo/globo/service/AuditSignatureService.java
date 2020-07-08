package sls.grupo.globo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sls.grupo.globo.entity.AuditSignature;
import sls.grupo.globo.entity.Signature;
import sls.grupo.globo.entity.SignatureDTO;
import sls.grupo.globo.entity.StatusSubscription;
import sls.grupo.globo.repository.AuditSignatureRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@Service
@Slf4j
public class AuditSignatureService {

    AuditSignatureRepository auditSignatureRepository;

    AuditSignature auditSignature;

    @Autowired
    AuditSignatureService(AuditSignatureRepository auditSignatureRepository){
        this.auditSignatureRepository = auditSignatureRepository;
    }

    public void setInputParameter(JoinPoint joinPoint) {
        Optional<SignatureDTO> signatureDTO = createSignature(joinPoint);
        signatureDTO.ifPresent(signature -> {
            this.auditSignature =  new AuditSignature().builder()
                    .createdAt(LocalDate.now())
                    .subscriptionId(signature.getSubscription())
                    .type(StatusSubscription.forName(signature.getNotificationType()).get())
                    .build();
        });
    }

    public void save() {
        this.auditSignatureRepository.save(this.auditSignature);
    }

    private Optional<SignatureDTO> createSignature(JoinPoint joinPoint) {
        try {
            String json = new ObjectMapper()
                    .writer()
                    .withDefaultPrettyPrinter()
                    .writeValueAsString(joinPoint.getArgs()[0]);
            return Optional.ofNullable(new ObjectMapper().readValue(json, Signature.class));
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
        return Optional.empty();
    }

}
