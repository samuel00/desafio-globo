package sls.grupo.globo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.stereotype.Service;
import sls.grupo.globo.entity.Subscription;
import sls.grupo.globo.entity.SubscriptionServiceImpl;
import sls.grupo.globo.repository.SignatureRepository;

import java.io.IOException;
import java.time.LocalDate;

@Service
@Slf4j
public class SubscriptionUpdateService extends SubscriptionServiceImpl {

    @Autowired
    SignatureRepository signatureRepository;

    final static String SUBSCRIPTION_RESTARTED = "SUBSCRIPTION_RESTARTED";

    public void processEvent(Subscription subscriptionJson) throws IOException {
        updateSignature(subscriptionJson);
        if (subscriptionJson.getSubscription() != null && subscriptionJson.getSubscription() == "000") {
            throw new RecoverableDataAccessException("Temporary Network Issue");
        }
    }

    private Subscription updateSignature(Subscription singSubscription) throws IOException {
        Subscription subscriptionDb = this.signatureRepository.findBySubscription(singSubscription.getSubscription())
                .orElseThrow(RuntimeException::new);
        subscriptionDb.withUpdateAt(LocalDate.now())
                .withStatusId(getStatus(singSubscription.getNotificationType()));
        return signatureRepository.save(subscriptionDb);
    }

    @Override
    public String getName() {
        return SUBSCRIPTION_RESTARTED;
    }
}

