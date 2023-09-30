package com.kooujin.marketingserver.configs;

import com.kooujin.marketingserver.entities.Buyer;
import com.kooujin.marketingserver.repositories.BuyerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.UUID;

@Configuration
@Profile("development")
public class TestConfig implements CommandLineRunner {
    private final BuyerRepository buyerRepository;

    public TestConfig(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    @Override
    public void run(String... args) {
        Buyer buyer = new Buyer(UUID.randomUUID(), "Test user", "test@email.com", "12312312312");

        buyerRepository.save(buyer);
    }
}
