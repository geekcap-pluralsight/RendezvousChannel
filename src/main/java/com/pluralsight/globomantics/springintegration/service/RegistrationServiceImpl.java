package com.pluralsight.globomantics.springintegration.service;

import com.pluralsight.globomantics.springintegration.config.RendezvousChannelGateway;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    private static final Logger logger = LogManager.getLogger(RegistrationServiceImpl.class);

    @Autowired
    private RendezvousChannelGateway rendezvousChannelGateway;

    @Override
    public boolean checkHotelAvailability(int partySize) {
        logger.info("Checking for hotel availability for {} guests", partySize);
        Message<Boolean> available = rendezvousChannelGateway.checkHotelAvailability(MessageBuilder.withPayload(partySize).build());
        logger.info("Hotel availability: {}", available.getPayload());

        return available.getPayload();
    }

}
