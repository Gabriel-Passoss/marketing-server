package com.kooujin.marketingserver.controllers;

import com.kooujin.marketingserver.dtos.FindUserDTO;
import com.kooujin.marketingserver.dtos.SaveAdminDTO;
import com.kooujin.marketingserver.entities.Buyer;
import com.kooujin.marketingserver.repositories.BuyerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController()
public class MainController {
    private final BuyerRepository buyerRepository;

    public MainController(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    @GetMapping("/buyer/findall")
    public ResponseEntity<List<Buyer>> findAllBuyers() {
        List<Buyer> buyers = buyerRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(buyers);
    }

    @PostMapping("/buyer/find")
    public ResponseEntity<Object> findBuyer(@RequestBody FindUserDTO user) {
        Optional<Buyer> buyer = Optional.empty();
        if (user.getCpf() != null) {
            buyer = buyerRepository.findByCpf(user.getCpf());
        } else if (user.getEmail() != null) {
            buyer = buyerRepository.findByEmail(user.getEmail());
        }


        if (buyer.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(buyer.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

    @PostMapping("/buyer/admin")
    public ResponseEntity<?> saveAdmin(@RequestBody SaveAdminDTO admin) {
        Optional<Buyer> savedBuyer = buyerRepository.findByCpf(admin.getCpf());

        if (savedBuyer.isEmpty()) {
            Buyer newBuyer = new Buyer(admin.getName(), admin.getEmail(), admin.getCpf());
            newBuyer.setAdmin(true);
            newBuyer.setBoughtCupom(true);
            newBuyer.setPremium(true);
            buyerRepository.save(newBuyer);
            return ResponseEntity.status(HttpStatus.CREATED).body(newBuyer);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Admin already exists");
    }
}
