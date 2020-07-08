package sls.grupo.globo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    /*@Column(name = "subscription_id")
    private String subscriptionID;

    @Column(name="created_at", columnDefinition = "DATE")
    private LocalDate createdAt;*/
}
