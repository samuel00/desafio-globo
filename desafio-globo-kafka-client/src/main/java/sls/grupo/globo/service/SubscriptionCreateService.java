package sls.grupo.globo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import sls.grupo.globo.common.PostMessageSendded;
import sls.grupo.globo.entity.*;
import sls.grupo.globo.repository.SignatureRepository;
import sls.grupo.globo.repository.StatusRepository;

import java.io.IOException;
import java.time.LocalDate;

@Service
@Slf4j
public class SubscriptionCreateService extends SubscriptionServiceImpl{

    @Autowired
    SignatureRepository signatureRepository;

    static final String SUBSCRIPTION_PURCHASED = "SUBSCRIPTION_PURCHASED";

    @Override
    public void processEvent(Subscription subscriptionJson) throws IOException {
        log.info("subscription : {} ", subscriptionJson);
        saveSubscription(subscriptionJson);
        if (subscriptionJson.getSubscription() != null && subscriptionJson.getSubscription() == "000") {
            throw new RecoverableDataAccessException("Temporary Network Issue");
        }
    }

    private Subscription saveSubscription(Subscription subscriptionJson) throws IOException {
        Subscription subscription = new Subscription().builder()
                .subscription(subscriptionJson.getSubscription())
                .notificationType(subscriptionJson.getNotificationType())
                .updatedAt(LocalDate.now())
                .createdAt(LocalDate.now())
                .statusId(getStatus(subscriptionJson.getNotificationType()))
                .build();
        Subscription subscriptionDB = signatureRepository.save(subscription);
        log.info("subscriptionDB : {} ", subscriptionDB);
        return signatureRepository.save(subscription);
    }

    @Override
    public String getName() {
        return SUBSCRIPTION_PURCHASED;
    }

}
