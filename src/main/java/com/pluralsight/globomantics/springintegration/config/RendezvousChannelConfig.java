package com.pluralsight.globomantics.springintegration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.RendezvousChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
public class RendezvousChannelConfig {
    @Bean
    public MessageChannel rendezvousChannel() {
        return new RendezvousChannel();
    }
}