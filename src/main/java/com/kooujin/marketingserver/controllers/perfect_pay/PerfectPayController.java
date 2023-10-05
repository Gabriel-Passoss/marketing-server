package com.kooujin.marketingserver.controllers.perfect_pay;

import com.kooujin.marketingserver.dtos.perfect_pay.PerfectPayDTO;
import com.kooujin.marketingserver.entities.Buyer;
import com.kooujin.marketingserver.repositories.BuyerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("/perfect")
public class PerfectPayController {

    private final BuyerRepository buyerRepository;

    public PerfectPayController(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    @PostMapping("/buyer")
    public ResponseEntity<?> saveBuyer(@RequestBody PerfectPayDTO buyer) {
        Optional<Buyer> savedBuyer = buyerRepository.findByCpf(buyer.getCustomer().getIdentification_number());

        if (savedBuyer.isEmpty()) {
            Buyer newBuyer = new Buyer(buyer.getCustomer().getFull_name(), buyer.getCustomer().getEmail(), buyer.getCustomer().getIdentification_number());
            return ResponseEntity.status(HttpStatus.CREATED).body(buyerRepository.save(newBuyer));
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
    }

    @PostMapping("/buyer/premium")
    public ResponseEntity<String> markAsPremium(@RequestBody PerfectPayDTO buyer) {
        Optional<Buyer> savedBuyer = buyerRepository.findByCpf(buyer.getCustomer().getIdentification_number());

        if (savedBuyer.isPresent()) {
            savedBuyer.get().setPremium(true);
            buyerRepository.save(savedBuyer.get());
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

    @PostMapping("/buyer/cupom")
    public ResponseEntity<String> markBoughtCupom(@RequestBody PerfectPayDTO buyer) {
        Optional<Buyer> savedBuyer = buyerRepository.findByCpf(buyer.getCustomer().getIdentification_number());

        if (savedBuyer.isPresent()) {
            savedBuyer.get().setBoughtCupom(true);
            buyerRepository.save(savedBuyer.get());
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

}
