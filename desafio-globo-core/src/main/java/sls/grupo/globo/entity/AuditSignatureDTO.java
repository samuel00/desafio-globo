package sls.grupo.globo.entity;

import java.time.LocalDate;

public interface AuditSignatureDTO {

    Long getId();

    String getSubscriptionId();

    String getType();

    LocalDate getCreatedAt();
}
