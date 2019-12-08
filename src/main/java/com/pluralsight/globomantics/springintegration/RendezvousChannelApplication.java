package com.pluralsight.globomantics.springintegration;

import com.pluralsight.globomantics.springintegration.service.RegistrationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RendezvousChannelApplication implements CommandLineRunner, ExitCodeGenerator {
	private static final Logger logger = LogManager.getLogger(RendezvousChannelApplication.class);

	@Autowired
	private RegistrationService registrationService;

	@Autowired
	private ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {
		boolean availableForFive = registrationService.checkHotelAvailability(5);
		boolean availableForTen = registrationService.checkHotelAvailability(10);

		try {
			// Wait for 10 seconds
			Thread.sleep(10000);
		} catch (Exception e) {}

		// Shutdown our spring application
		logger.info("Shutting down Spring Application after a 10 second delay");
		SpringApplication.exit(applicationContext, this);
    }

    @Override
    public int getExitCode() {
        return 0;
    }

	public static void main(String[] args) {
		SpringApplication.run(RendezvousChannelApplication.class, args);
	}
}
