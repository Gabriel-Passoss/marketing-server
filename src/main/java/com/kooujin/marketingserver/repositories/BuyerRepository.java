package com.kooujin.marketingserver.repositories;

import com.kooujin.marketingserver.entities.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

public interface BuyerRepository extends JpaRepository<Buyer, UUID> {
    Optional<Buyer> findByCpf(String cpf);
}
