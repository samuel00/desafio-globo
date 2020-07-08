package sls.grupo.globo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "eventyHistory")
public class AuditSignature implements AuditSignatureDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subscription_id")
    private String subscriptionId;

    @Column
    private String type;

    @Column(name="created_at", columnDefinition = "DATE")
    private LocalDate createdAt;
}
