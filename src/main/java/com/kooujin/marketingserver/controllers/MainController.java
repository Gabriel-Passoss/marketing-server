package com.kooujin.marketingserver.controllers;

import com.kooujin.marketingserver.entities.Buyer;
import com.kooujin.marketingserver.repositories.BuyerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController()
public class MainController {
    private final BuyerRepository buyerRepository;

    public MainController(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    @GetMapping("/buyer/{cpf}")
    public ResponseEntity<Object> findBuyer(@PathVariable(value = "cpf") String cpf) {
        Optional<Buyer> buyer = buyerRepository.findByCpf(cpf);

        if (buyer.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(buyer.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
}
