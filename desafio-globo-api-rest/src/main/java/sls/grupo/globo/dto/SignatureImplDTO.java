package sls.grupo.globo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sls.grupo.globo.entity.SignatureDTO;
import sls.grupo.globo.entity.StatusSubscription;
import sls.grupo.globo.api.validate.CustomerTypeSubset;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignatureImplDTO implements SignatureDTO {

    @NotNull
    @CustomerTypeSubset(anyOf = {StatusSubscription.SUBSCRIPTION_PURCHASED, StatusSubscription.SUBSCRIPTION_RESTARTED,
            StatusSubscription.SUBSCRIPTION_CANCELED})
    private StatusSubscription notificationType;

    @NotNull
    private String subscription;

    public String getNotificationType(){
        return Optional.ofNullable(this.notificationType).isPresent() ? this.notificationType.name() : null;
    }
}
