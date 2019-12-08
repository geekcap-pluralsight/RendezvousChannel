package com.pluralsight.globomantics.springintegration.config;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway(name = "rendezvousChannelGateway", defaultRequestChannel = "rendezvousChannel")
public interface RendezvousChannelGateway {
    @Gateway
    Message<Boolean> checkHotelAvailability(Message<Integer> partySize);
}