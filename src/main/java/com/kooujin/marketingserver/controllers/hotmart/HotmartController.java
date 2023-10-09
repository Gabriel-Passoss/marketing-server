package com.kooujin.marketingserver.controllers.hotmart;

import com.kooujin.marketingserver.dtos.hotmart.HotmartDTO;
import com.kooujin.marketingserver.dtos.pepper.PepperDTO;
import com.kooujin.marketingserver.entities.Buyer;
import com.kooujin.marketingserver.repositories.BuyerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("/hotmart")
public class HotmartController {

    private final BuyerRepository buyerRepository;

    public HotmartController(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    @PostMapping("/buyer")
    public ResponseEntity<?> saveBuyer(@RequestBody HotmartDTO buyer) {
        Optional<Buyer> savedBuyer = buyerRepository.findByEmail(buyer.getData().getBuyer().getEmail());

        if (savedBuyer.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        }

        if (buyer.getEvent().equals("PURCHASE_APPROVED")) {
            Buyer newBuyer = new Buyer(buyer.getData().getBuyer().getName(), buyer.getData().getBuyer().getEmail());
            return ResponseEntity.status(HttpStatus.CREATED).body(buyerRepository.save(newBuyer));
        }

        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body("Purchase status not valid!");
    }

    @PostMapping("/buyer/premium")
    public ResponseEntity<String> markAsPremium(@RequestBody HotmartDTO buyer) {
        Optional<Buyer> savedBuyer = buyerRepository.findByEmail(buyer.getData().getBuyer().getEmail());

        if (savedBuyer.isPresent()) {
            savedBuyer.get().setPremium(true);
            buyerRepository.save(savedBuyer.get());
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

    @PostMapping("/buyer/cupom")
    public ResponseEntity<String> markBoughtCupom(@RequestBody HotmartDTO buyer) {
        Optional<Buyer> savedBuyer = buyerRepository.findByEmail(buyer.getData().getBuyer().getEmail());

        if (savedBuyer.isPresent()) {
            savedBuyer.get().setBoughtCupom(true);
            buyerRepository.save(savedBuyer.get());
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

}
