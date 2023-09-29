package com.kooujin.marketingserver.controllers.perfect_pay;

import com.kooujin.marketingserver.dtos.perfect_pay.PerfectPayDTO;
import com.kooujin.marketingserver.entities.Buyer;
import com.kooujin.marketingserver.repositories.BuyerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController("/perfect")
public class PerfectPayController {

    private final BuyerRepository buyerRepository;

    public PerfectPayController(BuyerRepository buyerRepository) {
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
