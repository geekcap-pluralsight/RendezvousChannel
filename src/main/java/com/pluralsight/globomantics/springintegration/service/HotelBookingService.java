package com.pluralsight.globomantics.springintegration.service;

import org.springframework.messaging.Message;

public interface HotelBookingService {
    Message<Boolean> checkAvailability(Message<Integer> partySize);
}
