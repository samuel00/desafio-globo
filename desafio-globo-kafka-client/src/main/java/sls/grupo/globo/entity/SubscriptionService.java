package sls.grupo.globo.entity;

import java.io.IOException;

public interface SubscriptionService {

    void processEvent(Subscription subscription) throws IOException;

    String getName();
}
