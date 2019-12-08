package com.pluralsight.globomantics.springintegration.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class HotelBookingServiceImpl implements HotelBookingService {
    private static Logger logger = LogManager.getLogger(HotelBookingServiceImpl.class);

    @ServiceActivator(inputChannel = "rendezvousChannel", poller = @Poller(fixedDelay = "100"))
    @Override
    public Message<Boolean> checkAvailability(Message<Integer> partySize) {
        int numberOfGuests = partySize.getPayload();
        logger.info("Checking for rooms for {} guests", numberOfGuests);
        if (numberOfGuests < 10) {
            return MessageBuilder.withPayload(true).build();
        } else {
            return MessageBuilder.withPayload(false).build();
        }
    }
}
