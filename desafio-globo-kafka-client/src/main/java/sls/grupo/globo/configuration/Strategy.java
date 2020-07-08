package sls.grupo.globo.configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sls.grupo.globo.entity.SubscriptionService;

@Configuration
public class Strategy {

    @Bean(name = "subscriptionStrategy")
    Map<String, SubscriptionService> subscriptionStrategy(List<SubscriptionService> subscriptionServices) {
        Map<String, SubscriptionService> map = new HashMap<>();
        subscriptionServices.forEach(subscriptionService -> map.put(subscriptionService.getName(), subscriptionService));
        return map;
    }
}
