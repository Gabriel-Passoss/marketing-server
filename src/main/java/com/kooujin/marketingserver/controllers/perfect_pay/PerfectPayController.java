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
    public ResponseEntity<Buyer> saveBuyer(@RequestBody PerfectPayDTO buyer) {
        Buyer newBuyer = new Buyer(buyer.getCustomer().getFull_name(), buyer.getCustomer().getEmail(), buyer.getCustomer().getIdentification_number());
        return ResponseEntity.status(HttpStatus.CREATED).body(buyerRepository.save(newBuyer));
    }

}
